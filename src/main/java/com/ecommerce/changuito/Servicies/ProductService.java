
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.ProductDto;
import com.ecommerce.changuito.Errors.ErrorService;
import java.util.List;


public interface ProductService {
    
    ProductDto save(ProductDto productDto) throws ErrorService;
    ProductDto update(Long id, ProductDto productDto) throws ErrorService;
    public void delete(Long id)throws ErrorService;
    List<ProductDto> getAll();
    ProductDto getById(Long id)throws ErrorService;
    public void validation(ProductDto productDto) throws Exception;
}
