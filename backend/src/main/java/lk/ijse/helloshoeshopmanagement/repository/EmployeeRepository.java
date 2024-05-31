package lk.ijse.helloshoeshopmanagement.repository;

import lk.ijse.helloshoeshopmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
/**
 * @author Imalka Gayani
 */
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
