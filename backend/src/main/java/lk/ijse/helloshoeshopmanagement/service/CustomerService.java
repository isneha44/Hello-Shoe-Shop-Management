package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.dto.CustomerDTO;
import lk.ijse.helloshoeshopmanagement.entity.Customer;
import lk.ijse.helloshoeshopmanagement.enums.Level;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomer();
    Optional<CustomerDTO> findByCustomerCode(UUID customerCode);
    void deleteCustomer(UUID customerCode);
    List<CustomerDTO> findByJoinDate(Date joinDate);
    List<CustomerDTO> findByLevel(Level level);
    List<CustomerDTO> findByTotalPoint(int totalPoint);
    List<CustomerDTO> findByDOB(Date dob);
}
