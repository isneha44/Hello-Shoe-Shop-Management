package lk.ijse.helloshoeshopmanagement.service;

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
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Optional<Customer> findByCustomerCode(UUID customerCode);
    boolean deleteCustomer(Customer customerCode);
    Customer findByJoinDate(Date joinDate);
    Customer findByLevel(Level level);
    Customer findByTotalPoint(int totalPoint);
    Customer findByDOB(Date dob);

}
