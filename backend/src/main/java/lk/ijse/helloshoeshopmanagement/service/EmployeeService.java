package lk.ijse.helloshoeshopmanagement.service;



import lk.ijse.helloshoeshopmanagement.dto.CustomDTO;
import lk.ijse.helloshoeshopmanagement.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO dto);
    void updateEmployee(EmployeeDTO dto);
    void deleteEmployee(String id);
   /* EmployeeDTO searchEmpId(String code);*/

    EmployeeDTO searchEmpId(String code, String name);
    ArrayList<EmployeeDTO> loadAllEmployee();

    @ResponseBody
    CustomDTO employeeIdGenerate();
    CustomDTO getSumEmployee();
}
