package lk.ijse.helloshoeshopmanagement.serviceImpl;

import lk.ijse.helloshoeshopmanagement.entity.Employee;
import lk.ijse.helloshoeshopmanagement.repository.EmployeeRepository;
import lk.ijse.helloshoeshopmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findByEmployeeCode(UUID employeeCode) {
        return employeeRepository.findById(employeeCode);
    }

    @Override
    public boolean deleteEmployee(Employee employeeCode) {
        employeeRepository.delete(employeeCode);
        return true;
    }
}
