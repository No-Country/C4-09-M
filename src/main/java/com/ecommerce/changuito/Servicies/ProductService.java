
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.ProductDto;
import java.util.List;


public interface ProductService {
    
    ProductDto save(ProductDto productDto);
    ProductDto update(Long id, ProductDto productDto);
    public void delete(Long id)throws Exception;
    List<ProductDto> getAll();
}
