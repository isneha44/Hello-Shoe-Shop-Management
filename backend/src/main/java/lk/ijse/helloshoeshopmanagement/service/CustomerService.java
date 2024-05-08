package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author Imalka Gayani
 */
public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Optional<Customer> findByCustomerCode(String customerCode);
    boolean deleteCustomer(Customer customerCode);
}
