package uz.pdp.warehouse_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouse_app.entity.Input;
import uz.pdp.warehouse_app.entity.InputProduct;

import java.util.List;

/**
 * @author Sanjarbek Allayev, сб 20:38. 26.02.2022
 */

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
List<InputProduct> findAllByInput_Id(Integer id);
}
