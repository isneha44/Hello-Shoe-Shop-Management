package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.entity.Inventory;
import lk.ijse.helloshoeshopmanagement.repository.InventoryRepository;
import lk.ijse.helloshoeshopmanagement.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> findByItemCode(String itemCode) {
        return inventoryRepository.findById(itemCode);
    }

    @Override
    public boolean deleteInventory(Inventory itemCode) {
        inventoryRepository.delete(itemCode);
        return true ;
    }
}
