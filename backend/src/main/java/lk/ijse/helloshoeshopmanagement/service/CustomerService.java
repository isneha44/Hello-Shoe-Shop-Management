package lk.ijse.helloshoeshopmanagement.service;


import lk.ijse.helloshoeshopmanagement.dto.CustomDTO;
import lk.ijse.helloshoeshopmanagement.dto.CustomerDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public interface CustomerService {

    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    CustomerDTO searchCusId(String code, String name);
    CustomerDTO searchCusId(String code);
    ArrayList<CustomerDTO> loadAllCustomer();

    @ResponseBody
    CustomDTO customerIdGenerate();
    CustomDTO getSumCustomer();

}
