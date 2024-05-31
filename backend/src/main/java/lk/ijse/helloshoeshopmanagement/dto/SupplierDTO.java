package lk.ijse.helloshoeshopmanagement.dto;

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
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {

    private UUID supplierCode;
    private String supplierName;
    private Category category;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String addressLine5;
    private String addressLine6;
    private String contactNo1;
    private String contactNo2;
    private String email;
    private Date createDate;
    private Date updateDate;
}
