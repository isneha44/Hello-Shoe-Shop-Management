package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.AdminPanel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface AdminPanelRepository extends JpaRepository<AdminPanel, UUID> {
}
