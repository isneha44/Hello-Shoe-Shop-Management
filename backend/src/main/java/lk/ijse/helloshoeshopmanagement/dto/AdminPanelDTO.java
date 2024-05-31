package lk.ijse.helloshoeshopmanagement.dto;
/**
 * @author Imalka Gayani
 */

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
public class AdminPanelDTO {

    private UUID id;
    private double totalSales;
    private double totalProfit;
    private String mostSaleItem;
    private String mostSaleItemPic;
    private int mostSaleItemQty;
    private Date createDate;
    private Date updateDate;
}
