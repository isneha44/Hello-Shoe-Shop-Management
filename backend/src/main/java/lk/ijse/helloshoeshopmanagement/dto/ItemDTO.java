package lk.ijse.helloshoeshopmanagement.dto;


import lk.ijse.helloshoeshopmanagement.entity.Supplier;
import lk.ijse.helloshoeshopmanagement.enums.ShoeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {
    private String code;
    private String name;
    private Integer qty;
    private String itemPicture;
    private ShoeType shoeType;
    private Integer size;
    private Supplier supplier;
    private String supName;
    private Double salePrice;
    private Double buyPrice;
    private Double expectedProfit;
    private Double profitMargin;
    private String status;
}
