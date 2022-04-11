
package com.ecommerce.changuito.Mapper;

import com.ecommerce.changuito.Dto.ProductDto;
import com.ecommerce.changuito.Entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    
    private ModelMapper modelMapper= new ModelMapper();
    
    public Product productDtoToProduct(ProductDto productDto){
        Product product= modelMapper.map(productDto, Product.class);
        return product;
    }
    
    public ProductDto productToProductDto(Product product){
        ProductDto productDto= modelMapper.map(product, ProductDto.class);
        return productDto;
    }
    
    public List<ProductDto> productListToDto(List<Product> products){
        List<ProductDto> productDtos= new ArrayList();
        for (Product product : products) {
            productDtos.add(this.productToProductDto(product));
        }
        return productDtos;
    }
}
