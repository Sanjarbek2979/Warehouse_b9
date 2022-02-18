package uz.pdp.warehouse_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;

/**
 * @author Sanjarbek Allayev, пт 16:52. 18.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean active;
}
