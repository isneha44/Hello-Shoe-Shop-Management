package lk.ijse.helloshoeshopmanagement.controller;

import lk.ijse.helloshoeshopmanagement.entity.Employee;
import lk.ijse.helloshoeshopmanagement.enums.Gender;
import lk.ijse.helloshoeshopmanagement.enums.Role;
import lk.ijse.helloshoeshopmanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Imalka Gayani
 */
@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;
    private static final org.apache.logging.log4j.Logger loggerLog4J = LogManager.getLogger(EmployeeController.class);

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Map<String, String> credentials) {
        loggerLog4J.info("Start saveEmployee");
        try {
            String[] requiredFields = {"employeeName", "profilePic", "gender", "status", "designation", "accessRole",
                    "dob", "dateOfJoin", "attachedBranch", "addressLine1", "contactNo", "email", "emergencyContactPerson", "emergencyContactNo"};
            validateMap(credentials, requiredFields);

            Employee employee = new Employee();
            UUID employeeCode = credentials.get("employeeCode") != null ? UUID.fromString(credentials.get("employeeCode")) : null;

            if (employeeCode != null) {
                Optional<Employee> byID = employeeService.findByEmployeeCode(employeeCode);
                if (byID.isPresent()) {
                    employee.setEmployeeCode(employeeCode);
                }
            }
            employee.setEmployeeName(credentials.get("employeeName"));
            employee.setProfilePic(credentials.get("profilePic"));
            employee.setGender(Gender.valueOf(credentials.get("gender")));
            employee.setStatus(credentials.get("status"));
            employee.setDesignation(credentials.get("designation"));
            employee.setAccessRole(Role.valueOf(credentials.get("accessRole")));
            employee.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(credentials.get("dob")));
            employee.setDateOfJoin(new SimpleDateFormat("yyyy-MM-dd").parse(credentials.get("dateOfJoin")));
            employee.setAttachedBranch(credentials.get("attachedBranch"));
            employee.setAddressLine1(credentials.get("addressLine1"));
            employee.setAddressLine2(credentials.get("addressLine2"));
            employee.setAddressLine3(credentials.get("addressLine3"));
            employee.setAddressLine4(credentials.get("addressLine4"));
            employee.setAddressLine5(credentials.get("addressLine5"));
            employee.setContactNo(credentials.get("contactNo"));
            employee.setEmail(credentials.get("email"));
            employee.setEmergencyContactPerson(credentials.get("emergencyContactPerson"));
            employee.setEmergencyContactNo(credentials.get("emergencyContactNo"));

            return ResponseEntity.ok(employeeService.saveEmployee(employee));
        } catch (Exception e) {
            handleException(e);
            loggerLog4J.error("Error Occurred while saving Employee");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            loggerLog4J.info("End saveEmployee");
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        loggerLog4J.info("Start getAllEmployees");
        try {
            loggerLog4J.info("End getAllEmployees");
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam UUID employeeCode) {
        loggerLog4J.info("Start deleteEmployee");
        Optional<Employee> optionalEmployee = employeeService.findByEmployeeCode(employeeCode);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        try {
            Employee employee = optionalEmployee.get();
            employeeService.deleteEmployee(employee);
            loggerLog4J.info("End deleteEmployee");
            return ResponseEntity.ok("Employee Deleted Successfully");
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/employeeCode")
    public ResponseEntity<Optional<Employee>> findByEmployeeCode(@RequestParam UUID employeeCode) {
        loggerLog4J.info("Start findByEmployeeCode");
        try {
            loggerLog4J.info("End findByEmployeeCode");
            Optional<Employee> employee = employeeService.findByEmployeeCode(employeeCode);
            if (employee.isPresent()) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            handleException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void handleException(Exception e) {
        loggerLog4J.error("Error ", e);
        e.printStackTrace();
    }

    private void validateMap(Map<String, String> assetCategoryMap, String[] requiredFields) {
        for (String field : requiredFields) {
            if (assetCategoryMap.get(field) == null || assetCategoryMap.get(field).isEmpty()) {
                throw new IllegalArgumentException("Not found " + field);
            }
        }
    }
}

