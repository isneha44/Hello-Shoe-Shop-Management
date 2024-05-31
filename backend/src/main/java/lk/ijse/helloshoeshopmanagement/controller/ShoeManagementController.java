package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.ShoeManagement;
import lk.ijse.helloshoeshopmanagement.service.ShoeManagementService;
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
@RequestMapping("/api/shoeManagement")
@RequiredArgsConstructor
public class ShoeManagementController {

    @Autowired
    private final ShoeManagementService shoeManagementService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(ShoeManagementController.class);

    @PostMapping("/save")
    public ResponseEntity<ShoeManagement> saveShoe(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveShoe");
        try {
            String[] requiredFields = {"brand", "model", "price", "stockQty", "imageURL"};
            validateMap(credentials, requiredFields);

            ShoeManagement shoe = new ShoeManagement();
            UUID id = credentials.get("id") != null ? UUID.fromString(credentials.get("id")) : null;

            if (id != null) {
                Optional<ShoeManagement> byID = shoeManagementService.findById(id);
                if (byID.isPresent()) {
                    shoe.setId(id);
                }
            }

            shoe.setBrand(credentials.get("brand"));
            shoe.setModel(credentials.get("model"));
            shoe.setPrice(Double.parseDouble(credentials.get("price")));
            shoe.setStockQty(Integer.parseInt(credentials.get("stockQty")));
            shoe.setImageURL(credentials.get("imageURL"));

            Date currentDate = new Date();
            shoe.setUpdateDate(currentDate);
            if (id == null) {
                shoe.setCreateDate(currentDate);
            }

            return ResponseEntity.ok(shoeManagementService.saveShoe(shoe));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Shoe");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveShoe");
        }
    }

    @GetMapping
    public ResponseEntity<List<ShoeManagement>> getAllShoes() {
        loggerLog4J.info("Start getAllShoes");
        try {
            loggerLog4J.info("End getAllShoes");
            return ResponseEntity.ok(shoeManagementService.getAllShoes());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteShoe(@RequestParam UUID id) {
        loggerLog4J.info("Start deleteShoe");

        // Find the Shoe by id
        Optional<ShoeManagement> optionalShoe = shoeManagementService.findById(id);

        if (optionalShoe.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shoe not found");
        }

        try {
            ShoeManagement shoe = optionalShoe.get();
            shoeManagementService.deleteShoe(shoe);
            loggerLog4J.info("End deleteShoe");
            return ResponseEntity.ok("Shoe Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/shoeCode")
    public ResponseEntity<Optional<ShoeManagement>> findById(@RequestParam UUID id) {
        loggerLog4J.info("Start findById");
        try {
            loggerLog4J.info("End findById");
            Optional<ShoeManagement> shoe = shoeManagementService.findById(id);
            if (shoe.isPresent()) {
                return ResponseEntity.ok(shoe);
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
