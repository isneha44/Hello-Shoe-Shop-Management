package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.*;
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
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_CUSTOMER")
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID employeeCode;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    @Column(name = "PROFILE_PIC")
    private String profilePic;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "ACCESS_ROLE")
    private Role accessRole;
    @Column(name = "DOB")
    private Date dob;
    @Column(name = "DATE_OF_JOIN")
    private Date dateOfJoin;
    @Column(name = "ATTACHED_BRANCH")
    private String attachedBranch;
    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;
    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;
    @Column(name = "ADDRESS_LINE_3")
    private String addressLine3;
    @Column(name = "ADDRESS_LINE_4")
    private String addressLine4;
    @Column(name = "ADDRESS_LINE_5")
    private String addressLine5;
    @Column(name = "CONTACT_NO")
    private String contactNo;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "EMERGENCY_CONTACT_PERSON")
    private String emergencyContactPerson;
    @Column(name = "EMERGENCY_CONTACT_NO")
    private String emergencyContactNo;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;



}
