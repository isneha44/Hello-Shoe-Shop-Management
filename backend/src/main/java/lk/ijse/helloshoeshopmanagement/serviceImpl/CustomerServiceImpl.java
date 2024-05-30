package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.entity.Customer;
import lk.ijse.helloshoeshopmanagement.enums.Level;
import lk.ijse.helloshoeshopmanagement.repository.CustomerRepository;
import lk.ijse.helloshoeshopmanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findByCustomerCode(UUID customerCode) {
        return customerRepository.findById(customerCode);
    }

    @Override
    public boolean deleteCustomer(Customer customerCode) {
        customerRepository.delete(customerCode);
        return true;

    }

    @Override
    public Customer findByJoinDate(Date joinDate) {
        return customerRepository.findByJoinDate(joinDate);
    }

    @Override
    public Customer findByLevel(Level level) {
        return customerRepository.findByLevel(level);
    }

    @Override
    public Customer findByTotalPoint(int totalPoint) {
        return customerRepository.findByTotalPoint(totalPoint);
    }

    @Override
    public Customer findByDOB(Date dob) {
        return customerRepository.findByDob(dob);
    }
}



