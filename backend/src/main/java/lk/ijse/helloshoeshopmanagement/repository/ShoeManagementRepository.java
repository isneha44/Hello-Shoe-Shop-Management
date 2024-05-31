package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.ShoeManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
/**
 * @author Imalka Gayani
 */
public interface ShoeManagementRepository extends JpaRepository<ShoeManagement, UUID> {
}
