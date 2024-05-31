package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Imalka Gayani
 */
public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
