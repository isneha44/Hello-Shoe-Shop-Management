package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Imalka Gayani
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_SALE")
public class Sale {
    @Id
    private String itemCode;
    @Column(name = "ORDER_NO")
    private String orderNo;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "ITEM_DESCRIPTION")
    private String itemDesc;
    @Column(name = "SIZE")
    private int size;
    @Column(name = "UNIT_PRICE")
    private double unitPrice;
    @Column(name = "ITEM_QTY")
    private int itemQty;
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    @Column(name = "PURCHASE_DATE")
    private LocalDateTime purchaseDate;
    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;
    @Column(name = "ADDED_POINTS")
    private double addedPoints;
    @Column(name = "CASHIER_NAME")
    private String cashierName;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

}
