package uz.pdp.warehouse_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, сб 9:30. 26.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO {
private String name;
private String phoneNumber;
private boolean active;
}
