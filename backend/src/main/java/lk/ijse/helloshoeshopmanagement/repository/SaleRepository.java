package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
/**
 * @author Imalka Gayani
 */
public interface SaleRepository extends JpaRepository<Sale, UUID> {
    Sale findByPurchaseDate(LocalDateTime purchaseDate);

    List<Sale> findByCustomerName(String customerName);
}
