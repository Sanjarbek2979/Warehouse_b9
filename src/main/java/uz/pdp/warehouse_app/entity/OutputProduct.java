package uz.pdp.warehouse_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sanjarbek Allayev, пт 19:55. 18.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OutputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    Product product;

    @Column(nullable = false)
    private Double amount;


    @Column(nullable = false)
    private Double price;

    @ManyToOne
    Output output;

}
