package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.dto.CustomerDTO;
import lk.ijse.helloshoeshopmanagement.entity.Customer;

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
}
