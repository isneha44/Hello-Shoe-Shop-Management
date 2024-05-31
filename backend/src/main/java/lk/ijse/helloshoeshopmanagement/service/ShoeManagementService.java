package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.ShoeManagement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * @author Imalka Gayani
 */
public interface ShoeManagementService {

    ShoeManagement saveShoe(ShoeManagement shoe);
    List<ShoeManagement> getAllShoes();
    Optional<ShoeManagement> findById(UUID id);
    boolean deleteShoe(ShoeManagement id);
}
