
package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.ProductDto;
import com.ecommerce.changuito.error.ErrorService;

import java.util.List;


public interface ProductService {
    
    ProductDto save(ProductDto productDto) throws ErrorService;
    ProductDto update(Long id, ProductDto productDto) throws ErrorService;
    public void delete(Long id)throws ErrorService;
    List<ProductDto> getAll();
    ProductDto getById(Long id)throws ErrorService;
    public void validation(ProductDto productDto) throws Exception;
}
