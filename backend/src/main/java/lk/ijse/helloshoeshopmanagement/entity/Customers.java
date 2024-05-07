package lk.ijse.helloshoeshopmanagement.entity;

import com.nimbusds.openid.connect.sdk.claims.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
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
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "JOIN_DATE")
    private Date joinDate;
    @Column(name = "LEVEL")
    private String level;
    @Column(name = "TOTAL_POINT")
    private int totalPoint;
    @Column(name = "DOB")
    private Date dob;
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
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PURCHASE_DATE_AND_TIME")
    private Timestamp purchaseDateAndTime;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
}
