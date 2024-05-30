package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.dto.SaleDTO;
import lk.ijse.helloshoeshopmanagement.entity.Sale;
import lk.ijse.helloshoeshopmanagement.repository.SaleRepository;
import lk.ijse.helloshoeshopmanagement.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;


    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSale() {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findById(UUID saleId) {
        return saleRepository.findById(saleId);
    }

    @Override
    public boolean deleteSale(Sale id) {
        saleRepository.delete(id);
        return true;
    }

    @Override
    public List<Sale> findByPurchaseDate(LocalDateTime purchaseDate) {
        return (List<Sale>) saleRepository.findByPurchaseDate(purchaseDate);
    }

    @Override
    public List<Sale> findByCustomerName(String customerName) {
        return saleRepository.findByCustomerName(customerName);
    }
}
