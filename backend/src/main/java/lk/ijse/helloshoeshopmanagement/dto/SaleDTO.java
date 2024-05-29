package lk.ijse.helloshoeshopmanagement.dto;

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
public class SaleDTO {
    private String itemCode;
    private String orderNo;
    private String customerName;
    private String itemDesc;
    private int size;
    private double unitPrice;
    private int itemQty;
    private double totalPrice;
    private LocalDateTime purchaseDate;
    private String paymentMethod;
    private double addedPoints;
    private String cashierName;
    private Date createDate;
    private Date updateDate;
}
