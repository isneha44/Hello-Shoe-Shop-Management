package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.*;

import lk.ijse.helloshoeshopmanagement.embeded.Address;
import lk.ijse.helloshoeshopmanagement.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Embedded
    private Address address;
    private String contact1;
    private String contact2;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
}
