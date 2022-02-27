package uz.pdp.warehouse_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehouse_app.dto.InputDTO;
import uz.pdp.warehouse_app.dto.Response;
import uz.pdp.warehouse_app.entity.Input;
import uz.pdp.warehouse_app.entity.InputProduct;
import uz.pdp.warehouse_app.repository.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, сб 20:39. 26.02.2022
 */
@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ProductRepository productRepository;

    public Response add(InputDTO inputDTO) {

        Input input = new Input();

        List<InputProduct> inputProductList = new ArrayList<>();

        input.setCurrency(currencyRepository.findById(inputDTO.getCurrencyId()).get());
        input.setSupplier(supplierRepository.findById(inputDTO.getSupplierId()).get());
        input.setWarehouse(warehouseRepository.findById(inputDTO.getWarehouseId()).get());
        input.setCode(Services.getRandomNumber());
        input.setFactureNumber("№:".concat(Services.getRandomNumber()));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        input.setDate(timestamp);
        Input save = inputRepository.save(input);

        Integer[] amount = inputDTO.getAmount();
        Integer[] price = inputDTO.getPrice();
        String[] product = inputDTO.getProduct();

        for (int i = 1; i < amount.length; i++) {
            InputProduct inputProduct = new InputProduct();
            inputProduct.setInput(save);
            inputProduct.setProduct(productRepository.findById(Integer.parseInt(product[i])).get());
            inputProduct.setAmount(Double.valueOf(amount[i]));
            inputProduct.setPrice(Double.valueOf(price[i]));
         inputProductList.add(inputProduct);
        }
        inputProductRepository.saveAll(inputProductList);
        return new Response("Qo`shildi", true);
    }

    public Response edit(Integer id, InputDTO inputDTO) {
        Optional<Input> byId = inputRepository.findById(id);

        if (!byId.isPresent()) return new Response("Xatolik",false);
        List<InputProduct> inputProductList = new ArrayList<>();
        Input input = byId.get();
        List<InputProduct> allByInput_id = inputProductRepository.findAllByInput_Id(id);
        inputProductRepository.deleteAll(allByInput_id);
        input.setCurrency(currencyRepository.findById(inputDTO.getCurrencyId()).get());
        input.setSupplier(supplierRepository.findById(inputDTO.getSupplierId()).get());
        input.setWarehouse(warehouseRepository.findById(inputDTO.getWarehouseId()).get());
        input.setCode(Services.getRandomNumber());
        input.setFactureNumber("№:".concat(Services.getRandomNumber()));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        input.setDate(timestamp);
        Input save = inputRepository.save(input);

        Integer[] amount = inputDTO.getAmount();
        Integer[] price = inputDTO.getPrice();
        String[] product = inputDTO.getProduct();

        for (int i = 1; i < amount.length; i++) {
            InputProduct inputProduct = new InputProduct();
            inputProduct.setInput(save);
            inputProduct.setProduct(productRepository.findById(Integer.parseInt(product[i])).get());
            inputProduct.setAmount(Double.valueOf(amount[i]));
            inputProduct.setPrice(Double.valueOf(price[i]));
            inputProductList.add(inputProduct);
        }
        inputProductRepository.saveAll(inputProductList);
        return new Response("O`zgartirildi", true);
    }

    public Response delete(Integer id){
        List<InputProduct> allByInput_id = inputProductRepository.findAllByInput_Id(id);
        inputProductRepository.deleteAll(allByInput_id);
        inputRepository.deleteById(id);
        return new Response("O`chirildi",true);
    }
}
