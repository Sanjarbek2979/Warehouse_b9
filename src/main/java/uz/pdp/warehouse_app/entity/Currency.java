package uz.pdp.warehouse_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sanjarbek Allayev, пт 17:27. 18.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private boolean active;

}
