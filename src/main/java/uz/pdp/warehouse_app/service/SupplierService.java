package uz.pdp.warehouse_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse_app.dto.Response;
import uz.pdp.warehouse_app.dto.SupplierDTO;
import uz.pdp.warehouse_app.entity.Supplier;
import uz.pdp.warehouse_app.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, сб 9:34. 26.02.2022
 */
@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;


    public List<Supplier> getAll() {
        List<Supplier> all = supplierRepository.findAll();
        return all;
    }

    public Response add(SupplierDTO supplierDTO) {

        Supplier supplier = new Supplier();
        supplier.setActive(supplierDTO.isActive());
        supplier.setName(supplierDTO.getName());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplierRepository.save(supplier);
        return new Response("Qo`shildi",true);
    }
    public Response edit(Integer id,SupplierDTO supplierDTO) {

        Optional<Supplier> byId = supplierRepository.findById(id);
        Supplier supplier = byId.get();
        supplier.setActive(supplierDTO.isActive());
        supplier.setName(supplierDTO.getName());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplierRepository.save(supplier);
        return new Response("O`zgartirildi",true);
    }
    public Response delete(Integer id) {
        supplierRepository.deleteById(id);
        return new Response("O`chirildi",true);
    }
}
