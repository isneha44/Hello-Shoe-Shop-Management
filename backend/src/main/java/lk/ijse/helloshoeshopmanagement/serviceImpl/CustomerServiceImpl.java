package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.dto.CustomerDTO;
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
import java.util.stream.Collectors;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = mapToEntity(customerDTO);

        Date currentDate = new Date();
        customer.setUpdateDate(currentDate);
        if (customer.getCustomerCode() == null) {
            customer.setCreateDate(currentDate);
        }

        Customer savedCustomer = customerRepository.save(customer);
        return mapToDTO(savedCustomer);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> findByCustomerCode(UUID customerCode) {
        return customerRepository.findById(customerCode)
                .map(this::mapToDTO);
    }

    @Override
    public void deleteCustomer(UUID customerCode) {
        customerRepository.deleteById(customerCode);
    }

    @Override
    public List<CustomerDTO> findByJoinDate(Date joinDate) {
        return customerRepository.findByJoinDate(joinDate);
    }

    @Override
    public List<CustomerDTO> findByLevel(Level level) {
        return customerRepository.findByLevel(level);
    }

    @Override
    public List<CustomerDTO> findByTotalPoint(int totalPoint) {
        return customerRepository.findByTotalPoint(totalPoint);
    }

    @Override
    public List<CustomerDTO> findByDOB(Date dob) {
        return customerRepository.findByDob(dob);
    }

    private CustomerDTO mapToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerCode(customer.getCustomerCode().toString());
        customerDTO.setName(customer.getName());
        customerDTO.setGender(customer.getGender());
        customerDTO.setJoinDate(customer.getJoinDate());
        customerDTO.setLevel(customer.getLevel());
        customerDTO.setTotalPoint(customer.getTotalPoint());
        customerDTO.setDob(customer.getDob());
        customerDTO.setAddressLine1(customer.getAddressLine1());
        customerDTO.setAddressLine2(customer.getAddressLine2());
        customerDTO.setAddressLine3(customer.getAddressLine3());
        customerDTO.setAddressLine4(customer.getAddressLine4());
        customerDTO.setAddressLine5(customer.getAddressLine5());
        customerDTO.setContact(customer.getContact());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPurchaseDateAndTime(customer.getPurchaseDateAndTime());
        customerDTO.setCreateDate(customer.getCreateDate());
        customerDTO.setUpdateDate(customer.getUpdateDate());
        return customerDTO;
    }

    private Customer mapToEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        if (customerDTO.getCustomerCode() != null) {
            customer.setCustomerCode(UUID.fromString(customerDTO.getCustomerCode()));
        }
        customer.setName(customerDTO.getName());
        customer.setGender(customerDTO.getGender());
        customer.setJoinDate(customerDTO.getJoinDate());
        customer.setLevel(customerDTO.getLevel());
        customer.setTotalPoint(customerDTO.getTotalPoint());
        customer.setDob(customerDTO.getDob());
        customer.setAddressLine1(customerDTO.getAddressLine1());
        customer.setAddressLine2(customerDTO.getAddressLine2());
        customer.setAddressLine3(customerDTO.getAddressLine3());
        customer.setAddressLine4(customerDTO.getAddressLine4());
        customer.setAddressLine5(customerDTO.getAddressLine5());
        customer.setContact(customerDTO.getContact());
        customer.setEmail(customerDTO.getEmail());
        customer.setPurchaseDateAndTime(customerDTO.getPurchaseDateAndTime());
        customer.setCreateDate(customerDTO.getCreateDate());
        customer.setUpdateDate(customerDTO.getUpdateDate());
        return customer;
    }
}



