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

    List<CustomerDTO> findByTotalPoint(int totalPoint);

    List<CustomerDTO> findByDob(Date dob);

    List<CustomerDTO> findByLevel(Level level);

    List<CustomerDTO> findByJoinDate(Date joinDate);
}

