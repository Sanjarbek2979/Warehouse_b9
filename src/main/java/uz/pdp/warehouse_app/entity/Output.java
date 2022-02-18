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
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String factureNumber;

    @Column(nullable = false,unique = true)
    private String code;

    @Column(nullable = false)
    private Timestamp date;

    @OneToOne
    Currency currency;
    @ManyToOne
    Warehouse warehouse;
    @ManyToOne
    Client client;
}
