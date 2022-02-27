package uz.pdp.warehouse_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouse_app.entity.Product;
import uz.pdp.warehouse_app.entity.Warehouse;

/**
 * @author Sanjarbek Allayev, сб 20:38. 26.02.2022
 */

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
