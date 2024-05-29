package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.dto.SaleDTO;
import lk.ijse.helloshoeshopmanagement.entity.Sale;
import lk.ijse.helloshoeshopmanagement.repository.SaleRepository;
import lk.ijse.helloshoeshopmanagement.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {
        return null;
    }

    @Override
    public List<SaleDTO> getAllSale() {
        return null;
    }

    @Override
    public Optional<SaleDTO> findById(UUID saleId) {
        return Optional.empty();
    }

    @Override
    public void deleteSale(UUID id) {

    }
//    @Autowired
//    private final SaleRepository saleRepository;
//    @Override
//    public SaleDTO saveSale(SaleDTO saleDTO) {
//        Sale sale = mapToEntity(saleDTO);
//
//        Date currentDate = new Date();
//        sale.setUpdateDate(currentDate);
//        if (sale.getItemCode() == null) {
//            sale.setCreateDate(currentDate);
//        }
//
//        Sale savedSale = saleRepository.save(sale);
//        return mapToDTO(savedSale);
//    }
//
//    @Override
//    public List<SaleDTO> getAllSale() {
//        return saleRepository.findAll().stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<SaleDTO> findById(String itemCode) {
//        return saleRepository.findById(itemCode)
//                .map(this::mapToDTO);
//    }
//
//    @Override
//    public void deleteSale(String itemCode) {
//        saleRepository.deleteById(itemCode);
//    }
//
//    private SaleDTO mapToDTO(Sale sale) {
//        SaleDTO saleDTO = new SaleDTO();
//        saleDTO.setItemCode(sale.getItemCode());
//        saleDTO.setOrderNo(sale.getOrderNo());
//        saleDTO.setCustomerName(sale.getCustomerName());
//        saleDTO.setItemDesc(sale.getItemDesc());
//        saleDTO.setSize(sale.getSize());
//        saleDTO.setUnitPrice(sale.getUnitPrice());
//        saleDTO.setItemQty(sale.getItemQty());
//        saleDTO.setTotalPrice(sale.getTotalPrice());
//        saleDTO.setPurchaseDate(sale.getPurchaseDate());
//        saleDTO.setPaymentMethod(sale.getPaymentMethod());
//        saleDTO.setAddedPoints(sale.getAddedPoints());
//        saleDTO.setCashierName(sale.getCashierName());
//        saleDTO.setCreateDate(sale.getCreateDate());
//        saleDTO.setUpdateDate(sale.getUpdateDate());
//        return saleDTO;
//    }
//
//    private Sale mapToEntity(SaleDTO saleDTO) {
//        Sale sale = new Sale();
//        if (saleDTO.getItemCode() != null) {
//            sale.setItemCode(saleDTO.getItemCode());
//        }
//
//        sale.setOrderNo(saleDTO.getOrderNo());
//        sale.setCustomerName(saleDTO.getCustomerName());
//        sale.setItemDesc(saleDTO.getItemDesc());
//        sale.setSize(saleDTO.getSize());
//        sale.setUnitPrice(saleDTO.getUnitPrice());
//        sale.setItemQty(saleDTO.getItemQty());
//        sale.setTotalPrice(saleDTO.getTotalPrice());
//        sale.setPurchaseDate(saleDTO.getPurchaseDate());
//        sale.setPaymentMethod(saleDTO.getPaymentMethod());
//        sale.setAddedPoints(saleDTO.getAddedPoints());
//        sale.setCashierName(saleDTO.getCashierName());
//        sale.setCreateDate(saleDTO.getCreateDate());
//        sale.setUpdateDate(saleDTO.getUpdateDate());
//        return sale;
//    }
}
