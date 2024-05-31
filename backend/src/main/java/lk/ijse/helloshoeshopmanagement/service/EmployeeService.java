package lk.ijse.helloshoeshopmanagement.service;

import lk.ijse.helloshoeshopmanagement.entity.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * @author Imalka Gayani
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> findByEmployeeCode(UUID employeeCode);
    boolean deleteEmployee(Employee employeeCode);
}
