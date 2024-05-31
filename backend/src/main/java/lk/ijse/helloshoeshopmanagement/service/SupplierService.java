package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.Supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Optional<Supplier> findBySupplierCode(UUID supplierCode);
    boolean deleteSupplier(Supplier supplierCode);
}
