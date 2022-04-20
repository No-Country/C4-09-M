
package com.ecommerce.changuito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String brand;
    private String name;
    private String description;
    private ContentDto contentDto;
    private Long id_image;
    private Double wholesaler_price;
    private Double retail_price;
    private Integer quantity;
    private String status;
    private CategoryDto categoryDto;
}
