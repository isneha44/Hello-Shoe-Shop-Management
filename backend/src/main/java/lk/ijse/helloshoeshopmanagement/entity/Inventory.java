package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Imalka Gayani
 */
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String itemCode;
    @Column(name = "ITEM_DESCRIPTION")
    private String itemDesc;
    @Column(name = "ITEM_PICTURE")
    private String itemPicture;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "SIZE")
    private int size;
    @Column(name = "SUPPLIER_CODE")
    private String supplierCode;
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Column(name = "UNIT_PRICE_SALE")
    private double unitPriceSale;
    @Column(name = "UNIT_PRICE_BUY")
    private double unitPriceBuy;
    @Column(name = "EXPECTED_PROFIT")
    private double expectedProfit;
    @Column(name = "PROFIT_MARGIN")
    private double profitMargin;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;


}
