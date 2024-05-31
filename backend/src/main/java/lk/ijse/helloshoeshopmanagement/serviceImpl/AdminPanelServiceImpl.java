package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.entity.AdminPanel;
import lk.ijse.helloshoeshopmanagement.repository.AdminPanelRepository;
import lk.ijse.helloshoeshopmanagement.service.AdminPanelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor
public class AdminPanelServiceImpl implements AdminPanelService {

    @Autowired
    private AdminPanelRepository adminPanelRepository;

    @Override
    public AdminPanel saveAdminPanel(AdminPanel adminPanel) {
        return adminPanelRepository.save(adminPanel);
    }

    @Override
    public List<AdminPanel> getAllAdminPanels() {
        return adminPanelRepository.findAll();
    }

    @Override
    public Optional<AdminPanel> findById(UUID id) {
        return adminPanelRepository.findById(id);
    }

    @Override
    public boolean deleteAdminPanel(AdminPanel id) {
        adminPanelRepository.delete(id);
        return true;
    }
}
