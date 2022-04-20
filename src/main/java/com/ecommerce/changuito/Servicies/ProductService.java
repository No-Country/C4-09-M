
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.ProductDto;
import com.ecommerce.changuito.Entities.Product;
import com.ecommerce.changuito.Errors.ErrorService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    
    ProductDto save(ProductDto productDto) throws ErrorService;
    ProductDto update(Long id, ProductDto productDto) throws ErrorService;
    public void delete(Long id)throws ErrorService;
    List<ProductDto> getAll();
    public Page<Product> getAllPage(Pageable pageable);
    public Page<Product> searchPage(String q, Pageable pageable);
    public Page<Product>brandOrderByAsc( Pageable pageable);
    public Page<Product> brandOrderByDesc( Pageable pageable);
    public Page<Product> nameOrderByAsc( Pageable pageable);
    public Page<Product> nameOrderByDesc( Pageable pageable);
    public Page<Product> wholesaler_priceOrderByAsc( Pageable pageable);
    public Page<Product> wholesaler_priceOrderByDesc( Pageable pageable);
    public Page<Product> retail_priceOrderByAsc( Pageable pageable);
    public Page<Product> retail_priceOrderByDesc( Pageable pageable);
    public Page<Product> productForCategory(Long id,Pageable pageable);
    ProductDto getById(Long id)throws ErrorService;
    public void validation(ProductDto productDto) throws Exception;
}
