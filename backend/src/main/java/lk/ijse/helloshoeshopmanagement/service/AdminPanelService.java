package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.AdminPanel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface AdminPanelService {

    AdminPanel saveAdminPanel(AdminPanel adminPanel);
    List<AdminPanel> getAllAdminPanels();
    Optional<AdminPanel> findById(UUID id);
    boolean deleteAdminPanel(AdminPanel id);
}
