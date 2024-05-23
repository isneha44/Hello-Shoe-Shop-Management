package lk.ijse.helloshoeshopmanagement.entity;

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
@Table(name = "tbl_ADMIN_PANEL")
public class AdminPanel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "TOTAL_SALES")
    private double totalSales;
    @Column(name = "TOTAL_PROFIT")
    private double totalProfit;
    @Column(name = "MOST_SALE_ITEM")
    private String mostSaleItem;
    @Column(name = "MOST_SALE_ITEM_PIC")
    private String mostSaleItemPic;
    @Column(name = "MOST_SALE_ITEM_QTY")
    private int mostSaleItemQty;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
}
