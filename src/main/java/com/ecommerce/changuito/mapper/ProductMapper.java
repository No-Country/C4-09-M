package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dtos.ProductDto;
        import com.ecommerce.changuito.entities.Product;
        import java.util.ArrayList;
        import java.util.List;
        import org.modelmapper.ModelMapper;
        import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private ModelMapper modelMapper= new ModelMapper();

    public Product productDtoToProduct(ProductDto productDto){
        System.out.println("*** Product DTO to Entity ***");
        Product product= modelMapper.map(productDto, Product.class);
        return product;
    }

    public ProductDto productToProductDto(Product product){
        ProductDto productDto= modelMapper.map(product, ProductDto.class);
        System.out.println("*** Product to DTO ***");
        return productDto;
    }

    public List<ProductDto> productListToProductDtos(List<Product> products){
        List<ProductDto> productDtos= new ArrayList<>();
        for (Product product : products) {
            productDtos.add(this.productToProductDto(product));
        }
        return productDtos;
    }
}