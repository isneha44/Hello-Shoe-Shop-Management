package lk.ijse.helloshoeshopmanagement.dto;

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
public class ShoeManagementDTO {

    private UUID id;
    private String brand;
    private String model;
    private double price;
    private int stockQty;
    private String imageURL;
    private Date createDate;
    private Date updateDate;
}
