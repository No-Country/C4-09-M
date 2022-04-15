package com.ecommerce.changuito.services;


        import com.ecommerce.changuito.dtos.ProductDto;
        import java.util.List;


public interface ProductService {

    ProductDto save(ProductDto product);
    ProductDto update(Long id, ProductDto productDto);
    void delete(Long id)throws Exception;
    List<ProductDto> getAll();
}