package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.Customer;
import lk.ijse.helloshoeshopmanagement.enums.Gender;
import lk.ijse.helloshoeshopmanagement.enums.Level;
import lk.ijse.helloshoeshopmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

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
        try {
            String[] requiredFields = {"name", "gender", "level", "totalPoint", "dob", "addressLine1", "addressLine2", "addressLine3",
                    "addressLine4", "addressLine5", "contact", "email", "purchaseDateAndTime"};
            validateMap(credentials, requiredFields);
            Customer customer = new Customer();
            String customerCode = credentials.get("customerCode") != null ? credentials.get("customerCode") : null;

            if (customerCode != null) {
                Optional<Customer> byCode = customerService.findByCustomerCode(customerCode);
                if (byCode.isPresent()) {
                    customer.setCustomerCode(customerCode);
                }
            }
            customer.setName(credentials.get("name"));
            customer.setGender(Gender.valueOf(credentials.get("gender")));
            customer.setContact(credentials.get("contact"));
            customer.setLevel(Level.valueOf(credentials.get("level")));
            customer.setTotalPoint(Integer.parseInt(credentials.get("totalPoint")));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date Dob = dateFormat.parse(credentials.get("dob"));
            customer.setDob(Dob);
            customer.setAddressLine1(credentials.get("addressLine1"));
            customer.setAddressLine2(credentials.get("addressLine2"));
            customer.setAddressLine3(credentials.get("addressLine3"));
            customer.setAddressLine4(credentials.get("addressLine4"));
            customer.setAddressLine5(credentials.get("addressLine5"));
            customer.setContact(credentials.get("contact"));
            customer.setEmail(credentials.get("email"));
            customer.setPurchaseDateAndTime(Timestamp.valueOf(credentials.get("purchaseDateAndTime")));

            Date currentDate = new Date();
            customer.setUpdateDate(currentDate);
            if (customerCode == null) {
                customer.setCreateDate(currentDate);
            }
            return ResponseEntity.ok(customerService.saveCustomer(customer));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error occurred while saving customer", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveCustomer");
        }
    }

    private void handleException(Exception e) {
        loggerLog4J.error("Error ", e);
        e.printStackTrace();
    }


    private void validateMap(Map<String, String> assetCategoryMap, String[] requiredFields) {
        for (String field : requiredFields) {
            if (assetCategoryMap.get(field) == null || assetCategoryMap.get(field).isEmpty()) {
                throw new IllegalArgumentException("Not found " + field);
            }
        }
    }

}



