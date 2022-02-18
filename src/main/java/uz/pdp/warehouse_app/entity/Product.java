package uz.pdp.warehouse_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sanjarbek Allayev, пт 18:11. 18.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String code;
    private boolean active;

    @ManyToOne
    Category category;

    @OneToOne
    Attachment photo;

    @ManyToOne
    Measurement measurement;

    @ManyToOne
    @JoinColumn(name = "input_product_id")
    private InputProduct inputProduct;

    public InputProduct getInputProduct() {
        return inputProduct;
    }

    public void setInputProduct(InputProduct inputProduct) {
        this.inputProduct = inputProduct;
    }
}
