package uz.pdp.warehouse_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouse_app.entity.Supplier;

/**
 * @author Sanjarbek Allayev, сб 9:34. 26.02.2022
 */
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

}
