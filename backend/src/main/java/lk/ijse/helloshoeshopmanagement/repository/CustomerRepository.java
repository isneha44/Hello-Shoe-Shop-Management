package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Imalka Gayani
 */

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}

