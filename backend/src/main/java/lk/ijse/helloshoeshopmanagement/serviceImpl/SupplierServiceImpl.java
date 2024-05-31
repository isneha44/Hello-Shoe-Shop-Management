package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.entity.Supplier;
import lk.ijse.helloshoeshopmanagement.repository.SupplierRepository;
import lk.ijse.helloshoeshopmanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findBySupplierCode(UUID supplierCode) {
        return supplierRepository.findById(supplierCode);
    }

    @Override
    public boolean deleteSupplier(Supplier supplierCode) {
        supplierRepository.delete(supplierCode);
        return true;
    }
}
