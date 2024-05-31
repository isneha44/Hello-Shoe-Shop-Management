package lk.ijse.helloshoeshopmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ShoeManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String brand;
    private String model;
    private double price;
    private int stockQty;
    private String imageURL;
    private Date createDate;
    private Date updateDate;
}
