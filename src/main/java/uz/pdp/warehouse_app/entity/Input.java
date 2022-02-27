package uz.pdp.warehouse_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Sanjarbek Allayev, пт 18:57. 18.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String factureNumber;

    @Column(nullable = false,unique = true)
    private String code;

    private Timestamp date;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
    Currency currency;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Warehouse.class)
    Warehouse warehouse;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Supplier.class)
    Supplier supplier;
}
