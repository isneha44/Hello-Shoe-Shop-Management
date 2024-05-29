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

import java.sql.Timestamp;
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
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveCustomer");
        try {
            String[] requiredFields = {"name", "gender", "joinDate", "level", "totalPoint", "dob", "addressLine1","addressLine2","addressLine3","addressLine4","addressLine5","contact", "email", "purchaseDateAndTime"};
            validateMap(credentials, requiredFields);

            CustomerDTO customerDTO = mapToCustomerDTO(credentials);
            return ResponseEntity.ok(customerService.saveCustomer(customerDTO));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Customer");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveCustomer");
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        loggerLog4J.info("Start getAllCustomer");
        try {
            loggerLog4J.info("End getAllCustomer");
            return ResponseEntity.ok(customerService.getAllCustomer());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{customerCode}")
    public ResponseEntity<String> deleteCustomer(@PathVariable UUID customerCode) {
        loggerLog4J.info("Start deleteCustomer");

        Optional<CustomerDTO> optionalCustomer = customerService.findByCustomerCode(customerCode);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }

        try {
            customerService.deleteCustomer(customerCode);
            loggerLog4J.info("End deleteCustomer");
            return ResponseEntity.ok("Customer Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/customerCode")
    public ResponseEntity<CustomerDTO> findByCustomerCode(@RequestParam UUID customerCode) {
        loggerLog4J.info("Start findByCustomerId");
        try {
            Optional<CustomerDTO> customer = customerService.findByCustomerCode(customerCode);
            return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End findByCustomerId");
        }
    }

    @GetMapping("/join-date")
    public ResponseEntity<List<CustomerDTO>> findByJoinDate(@RequestParam Date joinDate) {
        loggerLog4J.info("Start findByJoinDate");
        try {
            List<CustomerDTO> customers = customerService.findByJoinDate(joinDate);
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End findByJoinDate");
        }
    }

    @GetMapping("/level")
    public ResponseEntity<List<CustomerDTO>> findByLevel(@RequestParam Level level) {
        loggerLog4J.info("Start findByLevel");
        try {
            List<CustomerDTO> customers = customerService.findByLevel(level);
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End findByLevel");
        }
    }

    @GetMapping("/total-points")
    public ResponseEntity<List<CustomerDTO>> findByTotalPoint(@RequestParam int totalPoint) {
        loggerLog4J.info("Start findByTotalPoint");
        try {
            List<CustomerDTO> customers = customerService.findByTotalPoint(totalPoint);
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End findByTotalPoint");
        }
    }

    @GetMapping("/dob")
    public ResponseEntity<List<CustomerDTO>> findByDOB(@RequestParam Date dob) {
        loggerLog4J.info("Start findByDOB");
        try {
            List<CustomerDTO> customers = customerService.findByDOB(dob);
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End findByDOB");
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

    private CustomerDTO mapToCustomerDTO(Map<String, String> credentials) throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(credentials.get("name"));
        customerDTO.setGender(Gender.valueOf(credentials.get("gender")));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        customerDTO.setJoinDate(dateFormat.parse(credentials.get("joinDate")));
        customerDTO.setLevel(Level.valueOf(credentials.get("level")));
        customerDTO.setTotalPoint(Integer.parseInt(credentials.get("totalPoint")));
        customerDTO.setDob(dateFormat.parse(credentials.get("dob")));
        customerDTO.setAddressLine1(credentials.get("addressLine1"));
        customerDTO.setAddressLine2(credentials.get("addressLine2"));
        customerDTO.setAddressLine3(credentials.get("addressLine3"));
        customerDTO.setAddressLine4(credentials.get("addressLine4"));
        customerDTO.setAddressLine5(credentials.get("addressLine5"));
        customerDTO.setContact(credentials.get("contact"));
        customerDTO.setEmail(credentials.get("email"));
        customerDTO.setPurchaseDateAndTime(LocalDateTime.parse(credentials.get("purchaseDateAndTime")));
        return customerDTO;


    }
}



