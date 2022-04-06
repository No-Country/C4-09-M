
package com.ecommerce.changuito.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories_Has_ProductsDto {
    private Long id;
    private Long id_category;
    private Long  id_product;
}
