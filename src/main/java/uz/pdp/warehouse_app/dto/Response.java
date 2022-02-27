package uz.pdp.warehouse_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, сб 9:37. 26.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
private String message;
private boolean success;

}
