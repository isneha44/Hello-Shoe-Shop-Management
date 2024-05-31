package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.User;
import lk.ijse.helloshoeshopmanagement.enums.Role;
import lk.ijse.helloshoeshopmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Imalka Gayani
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(UserController.class);

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveUser");
        try {
            String[] requiredFields = {"email", "password", "role"};
            validateMap(credentials, requiredFields);

            User user = new User();
            UUID id = credentials.get("id") != null ? UUID.fromString(credentials.get("id")) : null;

            if (id != null) {
                Optional<User> byID = userService.findById(id);
                if (byID.isPresent()) {
                    user.setId(id);
                }
            }

            user.setEmail(credentials.get("email"));
            user.setPassword(credentials.get("password"));
            user.setRole(Role.valueOf(credentials.get("role")));

            Date currentDate = new Date();
            user.setUpdateDate(currentDate);
            if (id == null) {
                user.setCreateDate(currentDate);
            }

            return ResponseEntity.ok(userService.saveUser(user));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving User");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveUser");
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        loggerLog4J.info("Start getAllUsers");
        try {
            loggerLog4J.info("End getAllUsers");
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam UUID id) {
        loggerLog4J.info("Start deleteUser");

        // Find the User by id
        Optional<User> optionalUser = userService.findById(id);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        try {
            User user = optionalUser.get();
            userService.deleteUser(user);
            loggerLog4J.info("End deleteUser");
            return ResponseEntity.ok("User Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/userCode")
    public ResponseEntity<Optional<User>> findById(@RequestParam UUID id) {
        loggerLog4J.info("Start findById");
        try {
            loggerLog4J.info("End findById");
            Optional<User> user = userService.findById(id);
            if (user.isPresent()) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void handleException(Exception e) {
        loggerLog4J.error("Error ", e);
        e.printStackTrace();
    }

    private void validateMap(Map<String, String> map, String[] requiredFields) {
        for (String field : requiredFields) {
            if (map.get(field) == null || map.get(field).isEmpty()) {
                throw new IllegalArgumentException("Not found " + field);
            }
        }
    }
}
