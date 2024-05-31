package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.Supplier;
import lk.ijse.helloshoeshopmanagement.enums.Category;
import lk.ijse.helloshoeshopmanagement.service.SupplierService;
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
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {

    @Autowired
    private final SupplierService supplierService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(SupplierController.class);

    @PostMapping("/save")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveSupplier");
        try {
            String[] requiredFields = {"supplierName", "category", "addressLine1", "addressLine2", "addressLine3",
                    "addressLine4", "addressLine5", "addressLine6", "contactNo1", "contactNo2", "email"};
            validateMap(credentials, requiredFields);

            Supplier supplier = new Supplier();
            UUID supplierCode = credentials.get("supplierCode") != null ? UUID.fromString(credentials.get("supplierCode")) : null;

            if (supplierCode != null) {
                Optional<Supplier> byID = supplierService.findBySupplierCode(supplierCode);
                if (byID.isPresent()) {
                    supplier.setSupplierCode(supplierCode);
                }
            }

            supplier.setSupplierName(credentials.get("supplierName"));
            supplier.setCategory(Category.valueOf(credentials.get("category")));
            supplier.setAddressLine1(credentials.get("addressLine1"));
            supplier.setAddressLine2(credentials.get("addressLine2"));
            supplier.setAddressLine3(credentials.get("addressLine3"));
            supplier.setAddressLine4(credentials.get("addressLine4"));
            supplier.setAddressLine5(credentials.get("addressLine5"));
            supplier.setAddressLine6(credentials.get("addressLine6"));
            supplier.setContactNo1(credentials.get("contactNo1"));
            supplier.setContactNo2(credentials.get("contactNo2"));
            supplier.setEmail(credentials.get("email"));

            Date currentDate = new Date();
            supplier.setUpdateDate(currentDate);
            if (supplierCode == null) {
                supplier.setCreateDate(currentDate);
            }

            return ResponseEntity.ok(supplierService.saveSupplier(supplier));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Supplier");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveSupplier");
        }
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        loggerLog4J.info("Start getAllSuppliers");
        try {
            loggerLog4J.info("End getAllSuppliers");
            return ResponseEntity.ok(supplierService.getAllSuppliers());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSupplier(@RequestParam UUID supplierCode) {
        loggerLog4J.info("Start deleteSupplier");

        // Find the Supplier by supplierCode
        Optional<Supplier> optionalSupplier = supplierService.findBySupplierCode(supplierCode);

        if (optionalSupplier.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found");
        }

        try {
            Supplier supplier = optionalSupplier.get();
            supplierService.deleteSupplier(supplier);
            loggerLog4J.info("End deleteSupplier");
            return ResponseEntity.ok("Supplier Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/supplierCode")
    public ResponseEntity<Optional<Supplier>> findBySupplierCode(@RequestParam UUID supplierCode) {
        loggerLog4J.info("Start findBySupplierCode");
        try {
            loggerLog4J.info("End findBySupplierCode");
            Optional<Supplier> supplier = supplierService.findBySupplierCode(supplierCode);
            if (supplier.isPresent()) {
                return ResponseEntity.ok(supplier);
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
