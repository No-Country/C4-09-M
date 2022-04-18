
package com.ecommerce.changuito.Dto;

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
    private Long id_content;
    private Long id_image;
    private Double wholesaler_price;
    private Double retail_price;
    private Integer quantity;
    private String status;
    private Long id_category;
}
