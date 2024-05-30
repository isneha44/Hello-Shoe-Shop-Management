package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.dto.CustomerDTO;
import lk.ijse.helloshoeshopmanagement.entity.Customer;
import lk.ijse.helloshoeshopmanagement.enums.Gender;
import lk.ijse.helloshoeshopmanagement.enums.Level;
import lk.ijse.helloshoeshopmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Imalka Gayani
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(CustomerController.class);

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveCustomer");
        try {
            String[] requiredFields = {"name", "gender", "joinDate", "level", "totalPoint", "dob", "addressLine1","addressLine2","addressLine3","addressLine4","addressLine5","contact", "email", "purchaseDateAndTime"};
            validateMap(credentials, requiredFields);

            Customer customer = new Customer();
            UUID customerCode = credentials.get("customerCode") != null ? UUID.fromString(credentials.get("customerCode")) : null;

            if (customerCode != null) {
                Optional<Customer> byID = customerService.findByCustomerCode(customerCode);
                if (byID.isPresent()) {
                    customer.setCustomerCode(customerCode);
                }
            }

            customer.setName(credentials.get("name"));
            customer.setGender(Gender.valueOf(credentials.get("gender")));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            customer.setJoinDate(dateFormat.parse(credentials.get("joinDate")));
            customer.setLevel(Level.valueOf(credentials.get("level")));
            customer.setTotalPoint(Integer.parseInt(credentials.get("totalPoint")));
            customer.setDob(dateFormat.parse(credentials.get("dob")));
            customer.setAddressLine1(credentials.get("addressLine1"));
            customer.setAddressLine2(credentials.get("addressLine2"));
            customer.setAddressLine3(credentials.get("addressLine3"));
            customer.setAddressLine4(credentials.get("addressLine4"));
            customer.setAddressLine5(credentials.get("addressLine5"));
            customer.setContact(credentials.get("contact"));
            customer.setEmail(credentials.get("email"));
            customer.setPurchaseDateAndTime(LocalDateTime.parse(credentials.get("purchaseDateAndTime")));

            Date currentDate = new Date();
            customer.setUpdateDate(currentDate);
            if (customerCode == null) {
                customer.setCreateDate(currentDate);
            }

            return ResponseEntity.ok(customerService.saveCustomer(customer));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Customer");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveCustomer");
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        loggerLog4J.info("Start getAllCustomer");
        try {
            loggerLog4J.info("End getAllCustomer");
            return ResponseEntity.ok(customerService.getAllCustomer());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItem(@RequestParam UUID customerCode) {
        loggerLog4J.info("Start deleteCustomer");

        // Find the Customer by customerCode
        Optional<Customer> optionalCustomer = customerService.findByCustomerCode(customerCode);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }

        try {
            Customer customer = optionalCustomer.get();
            customerService.deleteCustomer(customer );
            loggerLog4J.info("End deleteCustomer");
            return ResponseEntity.ok("Customer Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }


    }

    @PostMapping("/joinDate")
    public ResponseEntity<Customer> findByJoinDate(@RequestBody Map<String, String> requestBody) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        loggerLog4J.info("Start findByJoinDate");
        try {
            String joinDateString = requestBody.get("joinDate");
            if (joinDateString == null) {
                return ResponseEntity.badRequest().build();
            }
            Date joinDate = dateFormat.parse(joinDateString);
            Customer customer = customerService.findByJoinDate(joinDate);
            if (customer != null) {
                loggerLog4J.info("End findByJoinDate");
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/level")
    public ResponseEntity<Customer> findByLevel(@RequestParam Level level) {
        loggerLog4J.info("Start findByLevel");
        try {
            loggerLog4J.info("End findByLevel");
            Customer customer = customerService.findByLevel(level);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/totalPoint")
    public ResponseEntity<Customer> findByTotalPoint(@RequestParam int totalPoint) {
        loggerLog4J.info("Start findByTotalPoint");
        try {
            loggerLog4J.info("End findByTotalPoint");
            Customer customer = customerService.findByTotalPoint(totalPoint);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/dob")
    public ResponseEntity<Customer> findByDOB(@RequestBody Map<String, String> requestBody) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        loggerLog4J.info("Start findByDOB");
        try {
            String dobString = requestBody.get("dob");
            if (dobString == null) {
                return ResponseEntity.badRequest().build();
            }
            Date dob = dateFormat.parse(dobString);
            Customer customer = customerService.findByDOB(dob);
            if (customer != null) {
                loggerLog4J.info("End findByDOB");
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void handleException(Exception e) {
        loggerLog4J.error("Error", e);
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



