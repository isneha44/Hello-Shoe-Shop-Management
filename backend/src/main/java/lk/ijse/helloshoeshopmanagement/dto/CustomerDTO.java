package lk.ijse.helloshoeshopmanagement.dto;

import lk.ijse.helloshoeshopmanagement.enums.Gender;
import lk.ijse.helloshoeshopmanagement.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Imalka Gayani
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String customerCode;

    private String name;

    private Gender gender;

    private Date joinDate;

    private Level level;

    private int totalPoint;

    private Date dob;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String addressLine4;

    private String addressLine5;

    private String contact;

    private String email;

    private LocalDateTime purchaseDateAndTime;

    private Date createDate;

    private Date updateDate;
}
