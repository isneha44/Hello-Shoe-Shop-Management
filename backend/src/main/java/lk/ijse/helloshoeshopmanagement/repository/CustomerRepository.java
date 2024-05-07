package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Imalka Gayani
 */

    public interface CustomerRepository extends JpaRepository<Customers, String> {
    }

