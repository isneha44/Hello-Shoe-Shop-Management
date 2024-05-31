package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.Inventory;

import java.util.List;
import java.util.Optional;
/**
 * @author Imalka Gayani
 */
public interface InventoryService {
    Inventory saveInventory(Inventory inventory);
    List<Inventory> getAllInventories();
    Optional<Inventory> findByItemCode(String itemCode);
    boolean deleteInventory(Inventory itemCode);
}
