package lk.ijse.helloshoeshopmanagement.dto;

import lk.ijse.helloshoeshopmanagement.enums.Gender;
import lk.ijse.helloshoeshopmanagement.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;
/**
 * @author Imalka Gayani
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private UUID employeeCode;
    private String employeeName;
    private String profilePic;
    private Gender gender;
    private String status;
    private String designation;
    private Role accessRole;
    private Date dob;
    private Date dateOfJoin;
    private String attachedBranch;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contactNo;
    private String email;
    private String emergencyContactPerson;
    private String emergencyContactNo;
    private Date createDate;
    private Date updateDate;
}
