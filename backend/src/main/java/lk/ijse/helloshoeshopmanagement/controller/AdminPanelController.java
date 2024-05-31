package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.AdminPanel;
import lk.ijse.helloshoeshopmanagement.service.AdminPanelService;
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
@RequestMapping("/api/adminPanel")
@RequiredArgsConstructor
public class AdminPanelController {

    @Autowired
    private final AdminPanelService adminPanelService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(AdminPanelController.class);

    @PostMapping("/save")
    public ResponseEntity<AdminPanel> saveAdminPanel(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveAdminPanel");
        try {
            String[] requiredFields = {"totalSales", "totalProfit", "mostSaleItem", "mostSaleItemPic", "mostSaleItemQty"};
            validateMap(credentials, requiredFields);

            AdminPanel adminPanel = new AdminPanel();
            UUID id = credentials.get("id") != null ? UUID.fromString(credentials.get("id")) : null;

            if (id != null) {
                Optional<AdminPanel> byID = adminPanelService.findById(id);
                if (byID.isPresent()) {
                    adminPanel.setId(id);
                }
            }

            adminPanel.setTotalSales(Double.parseDouble(credentials.get("totalSales")));
            adminPanel.setTotalProfit(Double.parseDouble(credentials.get("totalProfit")));
            adminPanel.setMostSaleItem(credentials.get("mostSaleItem"));
            adminPanel.setMostSaleItemPic(credentials.get("mostSaleItemPic"));
            adminPanel.setMostSaleItemQty(Integer.parseInt(credentials.get("mostSaleItemQty")));

            Date currentDate = new Date();
            adminPanel.setUpdateDate(currentDate);
            if (id == null) {
                adminPanel.setCreateDate(currentDate);
            }

            return ResponseEntity.ok(adminPanelService.saveAdminPanel(adminPanel));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving AdminPanel");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveAdminPanel");
        }
    }

    @GetMapping
    public ResponseEntity<List<AdminPanel>> getAllAdminPanels() {
        loggerLog4J.info("Start getAllAdminPanels");
        try {
            loggerLog4J.info("End getAllAdminPanels");
            return ResponseEntity.ok(adminPanelService.getAllAdminPanels());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAdminPanel(@RequestParam UUID id) {
        loggerLog4J.info("Start deleteAdminPanel");

        // Find the AdminPanel by id
        Optional<AdminPanel> optionalAdminPanel = adminPanelService.findById(id);

        if (optionalAdminPanel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AdminPanel not found");
        }

        try {
            AdminPanel adminPanel = optionalAdminPanel.get();
            adminPanelService.deleteAdminPanel(adminPanel);
            loggerLog4J.info("End deleteAdminPanel");
            return ResponseEntity.ok("AdminPanel Deleted Successfully");

        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/adminPanelCode")
    public ResponseEntity<Optional<AdminPanel>> findById(@RequestParam UUID id) {
        loggerLog4J.info("Start findById");
        try {
            loggerLog4J.info("End findById");
            Optional<AdminPanel> adminPanel = adminPanelService.findById(id);
            if (adminPanel.isPresent()) {
                return ResponseEntity.ok(adminPanel);
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
