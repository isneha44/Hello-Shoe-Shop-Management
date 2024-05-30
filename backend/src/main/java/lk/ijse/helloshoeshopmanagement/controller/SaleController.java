package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.Sale;
import lk.ijse.helloshoeshopmanagement.service.SaleService;
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
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {

    @Autowired
    private final SaleService saleService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(SaleController.class);

    @PostMapping("/save")
    public ResponseEntity<Sale> saveSale(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveSale");
        try {
            String[] requiredFields = {"itemCode", "orderNo", "customerName", "itemDesc", "size", "unitPrice", "itemQty", "totalPrice", "purchaseDate", "paymentMethod", "addedPoints", "cashierName"};
            validateMap(credentials, requiredFields);

            Sale sale = new Sale();
            UUID saleId = credentials.get("saleId") != null ? UUID.fromString(credentials.get("saleId")) : null;

            if (saleId != null) {
                Optional<Sale> byID = saleService.findById(saleId);
                if (byID.isPresent()) {
                    sale.setSaleId(saleId);
                }
            }

            sale.setItemCode(credentials.get("itemCode"));
            sale.setOrderNo(credentials.get("orderNo"));
            sale.setCustomerName(credentials.get("customerName"));
            sale.setItemDesc(credentials.get("itemDesc"));
            sale.setSize(Integer.parseInt(credentials.get("size")));
            sale.setUnitPrice(Double.parseDouble(credentials.get("unitPrice")));
            sale.setItemQty(Integer.parseInt(credentials.get("itemQty")));
            sale.setTotalPrice(Double.parseDouble(credentials.get("totalPrice")));
            sale.setPurchaseDate(LocalDateTime.parse(credentials.get("purchaseDate")));
            sale.setPaymentMethod(credentials.get("paymentMethod"));
            sale.setAddedPoints(Double.parseDouble(credentials.get("addedPoints")));
            sale.setCashierName(credentials.get("cashierName"));

            Date currentDate = new Date();
            sale.setUpdateDate(currentDate);
            if (saleId == null) {
                sale.setCreateDate(currentDate);
            }

            return ResponseEntity.ok(saleService.saveSale(sale));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Sale");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveSale");
        }
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        loggerLog4J.info("Start getAllSale");
        try {
            loggerLog4J.info("End getAllSale");
            return ResponseEntity.ok(saleService.getAllSale());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteSale(@RequestParam UUID saleId) {
        loggerLog4J.info("Start deleteSale");

        Optional<Sale> optionalSale = saleService.findById(saleId);

        if (optionalSale.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sale not found");
        }

        try {
            Sale sale = optionalSale.get();
            saleService.deleteSale(sale);
            loggerLog4J.info("End deleteSale");
            return ResponseEntity.ok("Sale Deleted Successfully");
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/customerName")
    public ResponseEntity<List<Sale>> findByCustomerName(@RequestParam String customerName) {
        loggerLog4J.info("Start findByCustomerName");
        try {
            loggerLog4J.info("End findByCustomerName");
            List<Sale> sales = (List<Sale>) saleService.findByCustomerName(customerName);
            if (!sales.isEmpty()) {
                return ResponseEntity.ok(sales);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/purchaseDate")
    public ResponseEntity<List<Sale>> findByPurchaseDate(@RequestBody Map<String, String> requestBody) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        loggerLog4J.info("Start findByPurchaseDate");
        try {
            String purchaseDateString = requestBody.get("purchaseDate");
            if (purchaseDateString == null) {
                return ResponseEntity.badRequest().build();
            }
            LocalDateTime purchaseDate = LocalDateTime.parse(purchaseDateString);
            List<Sale> sales = (List<Sale>) saleService.findByPurchaseDate(purchaseDate);
            if (!sales.isEmpty()) {
                loggerLog4J.info("End findByPurchaseDate");
                return ResponseEntity.ok(sales);
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

    private void validateMap(Map<String, String> credentials, String[] requiredFields) {
        for (String field : requiredFields) {
            if (credentials.get(field) == null || credentials.get(field).isEmpty()) {
                throw new IllegalArgumentException("Not found " + field);
            }
        }
    }


}
