package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import lk.ijse.helloshoeshopmanagement.enums.ShoeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    @Id
    private String code;
    private String name;
    private Integer qty;
    @Column(columnDefinition = "LONGTEXT")
    private String itemPicture;
    @Enumerated(EnumType.STRING)
    private ShoeType shoeType;
    private Integer size;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "supplier_id", referencedColumnName = "code", nullable = false)
    private Supplier supplier;
    private String supName;
    private Double salePrice;
    private Double buyPrice;
    private Double expectedProfit;
    private Double profitMargin;
    private String status;

}
