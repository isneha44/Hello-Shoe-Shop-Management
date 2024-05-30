package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.dto.CustomerDTO;
import lk.ijse.helloshoeshopmanagement.entity.Customer;
import lk.ijse.helloshoeshopmanagement.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findByTotalPoint(int totalPoint);

    Customer findByDob(Date dob);

    Customer findByLevel(Level level);

    Customer findByJoinDate(Date joinDate);
}

