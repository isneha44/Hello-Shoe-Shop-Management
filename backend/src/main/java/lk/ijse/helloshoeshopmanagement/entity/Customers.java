package lk.ijse.helloshoeshopmanagement.entity;

import com.nimbusds.openid.connect.sdk.claims.Gender;
import jakarta.persistence.*;
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
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String gender;
    private Date joinDate;
    private String level;
    private String totalPoint;
    private String dob;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String contact;
    private String email;
    private String purchaseDateAndTime;
    private Date updateDate;
    private Date createDate;
}
