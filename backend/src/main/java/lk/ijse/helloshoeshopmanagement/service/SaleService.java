package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.dto.SaleDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaleService {
    SaleDTO saveSale(SaleDTO saleDTO);
    List<SaleDTO> getAllSale();
    Optional<SaleDTO> findById(UUID saleId);
    void deleteSale(UUID id);
}
