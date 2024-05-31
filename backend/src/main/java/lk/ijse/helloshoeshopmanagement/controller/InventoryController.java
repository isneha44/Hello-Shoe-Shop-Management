package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.Inventory;
import lk.ijse.helloshoeshopmanagement.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Imalka Gayani
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(InventoryController.class);

    @PostMapping("/save")
    public ResponseEntity<Inventory> saveInventory(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveInventory");
        try {
            String[] requiredFields = {"itemCode", "itemDesc", "itemPicture", "category", "size", "supplierCode",
                    "supplierName", "unitPriceSale", "unitPriceBuy", "expectedProfit", "profitMargin", "status"};
            validateMap(credentials, requiredFields);

            Inventory inventory = new Inventory();
            inventory.setItemCode(credentials.get("itemCode"));
            inventory.setItemDesc(credentials.get("itemDesc"));
            inventory.setItemPicture(credentials.get("itemPicture"));
            inventory.setCategory(credentials.get("category"));
            inventory.setSize(Integer.parseInt(credentials.get("size")));
            inventory.setSupplierCode(credentials.get("supplierCode"));
            inventory.setSupplierName(credentials.get("supplierName"));
            inventory.setUnitPriceSale(Double.parseDouble(credentials.get("unitPriceSale")));
            inventory.setUnitPriceBuy(Double.parseDouble(credentials.get("unitPriceBuy")));
            inventory.setExpectedProfit(Double.parseDouble(credentials.get("expectedProfit")));
            inventory.setProfitMargin(Double.parseDouble(credentials.get("profitMargin")));
            inventory.setStatus(credentials.get("status"));

            Date currentDate = new Date();
            inventory.setUpdateDate(currentDate);
            if (credentials.get("createDate") == null) {
                inventory.setCreateDate(currentDate);
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                inventory.setCreateDate(dateFormat.parse(credentials.get("createDate")));
            }

            return ResponseEntity.ok(inventoryService.saveInventory(inventory));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Inventory");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveInventory");
        }
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        loggerLog4J.info("Start getAllInventories");
        try {
            loggerLog4J.info("End getAllInventories");
            return ResponseEntity.ok(inventoryService.getAllInventories());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteInventory(@RequestParam String itemCode) {
        loggerLog4J.info("Start deleteInventory");

        // Find the Inventory by itemCode
        Optional<Inventory> optionalInventory = inventoryService.findByItemCode(itemCode);

        if (optionalInventory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inventory not found");
        }

        try {
            Inventory inventory = optionalInventory.get();
            inventoryService.deleteInventory(inventory);
            loggerLog4J.info("End deleteInventory");
            return ResponseEntity.ok("Inventory Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/itemCode")
    public ResponseEntity<Optional<Inventory>> findByItemCode(@RequestParam String itemCode) {
        loggerLog4J.info("Start findByItemCode");
        try {
            loggerLog4J.info("End findByItemCode");
            Optional<Inventory> inventory = inventoryService.findByItemCode(itemCode);
            if (inventory.isPresent()) {
                return ResponseEntity.ok(inventory);
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
