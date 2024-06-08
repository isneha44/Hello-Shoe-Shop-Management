package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.*;
;
import lk.ijse.helloshoeshopmanagement.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "sales")
public class Sales {
    @Id
    private String oid;
    private String purchaseDate;
    private Double total;
    @Enumerated(EnumType.STRING)
    private Payment paymentMethod;
    private Integer totalPoints;
    private String cashier;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_name",referencedColumnName = "code", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sale")
    private List<SaleDetails> saleDetails = new ArrayList<>();
}
