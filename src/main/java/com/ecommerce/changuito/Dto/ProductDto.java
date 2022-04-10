
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
    private Double price;
    private Integer quantity;
    private String status;
    private Long id_category;
}
