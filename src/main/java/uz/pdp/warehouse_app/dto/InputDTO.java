package uz.pdp.warehouse_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Sanjarbek Allayev, сб 9:30. 26.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputDTO {
    private Integer warehouseId;
    private Integer currencyId;
    private Integer supplierId;
    private String[] product;
    private Integer[] amount;
    private Integer[] price;


}
