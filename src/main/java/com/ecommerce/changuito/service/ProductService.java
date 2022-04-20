
package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.ProductDto;
import com.ecommerce.changuito.entity.Product;
import com.ecommerce.changuito.error.ErrorService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    
    ProductDto save(ProductDto productDto) throws ErrorService;
    ProductDto update(Long id, ProductDto productDto) throws ErrorService;
    void delete(Long id)throws ErrorService;
    ProductDto getById(Long id) throws ErrorService;
    void validation(ProductDto productDto) throws ErrorService;
    List<ProductDto> getAll();
    Page<Product> getAllPage(Pageable pageable);
    Page<Product> searchPage(String q, Pageable pageable);
    Page<Product>brandOrderByAsc(Pageable pageable);
    Page<Product> brandOrderByDesc(Pageable pageable);
    Page<Product> nameOrderByAsc(Pageable pageable);
    Page<Product> nameOrderByDesc(Pageable pageable);
    Page<Product> wholesaler_priceOrderByAsc(Pageable pageable);
    Page<Product> wholesaler_priceOrderByDesc(Pageable pageable);
    Page<Product> retail_priceOrderByAsc(Pageable pageable);
    Page<Product> retail_priceOrderByDesc(Pageable pageable);
    Page<Product> productForCategory(Long id, Pageable pageable);
}
