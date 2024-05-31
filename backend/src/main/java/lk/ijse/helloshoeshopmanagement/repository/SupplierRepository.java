package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
}
