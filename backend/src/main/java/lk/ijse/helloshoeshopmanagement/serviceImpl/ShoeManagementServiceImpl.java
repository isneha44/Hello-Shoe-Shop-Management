package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.entity.ShoeManagement;
import lk.ijse.helloshoeshopmanagement.repository.ShoeManagementRepository;
import lk.ijse.helloshoeshopmanagement.service.ShoeManagementService;
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
public class ShoeManagementServiceImpl implements ShoeManagementService {

    @Autowired
    private ShoeManagementRepository shoeManagementRepository;

    @Override
    public ShoeManagement saveShoe(ShoeManagement shoe) {
        return shoeManagementRepository.save(shoe);
    }

    @Override
    public List<ShoeManagement> getAllShoes() {
        return shoeManagementRepository.findAll();
    }

    @Override
    public Optional<ShoeManagement> findById(UUID id) {
        return shoeManagementRepository.findById(id);
    }

    @Override
    public boolean deleteShoe(ShoeManagement id) {
        shoeManagementRepository.delete(id);
        return true;
    }
}
