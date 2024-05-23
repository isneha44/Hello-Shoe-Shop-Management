package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoeshopmanagement.enums.Category;
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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID supplierCode;
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Column(name = "CATEGORY")
    private Category category;
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
    @Column(name = "ADDRESS_LINE_6")
    private String addressLine6;
    @Column(name = "CONTACT_NO_1")
    private String contactNo1;
    @Column(name = "CONTACT_NO_2")
    private String contactNo2;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

}
