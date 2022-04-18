package com.ecommerce.changuito.services.impl;
        import com.ecommerce.changuito.dtos.ProductDto;
        import com.ecommerce.changuito.entities.Product;
        import com.ecommerce.changuito.mapper.ProductMapper;
        import com.ecommerce.changuito.repositories.ProductRepository;
        import com.ecommerce.changuito.services.ProductService;
        import java.util.List;
        import java.util.Optional;
        import javax.transaction.Transactional;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        Product productRepo = productRepository.save(product);
        return productMapper.productToProductDto(productRepo);
    }

    @Override
    @Transactional
    public ProductDto update(Long id, ProductDto productDto) {
        Optional<Product> answer = productRepository.findById(id);
        if (answer.isPresent()) {
            Product product = answer.get();
            product = productMapper.productDtoToProduct(productDto);
            product = productRepository.save(product);
            return productMapper.productToProductDto(product);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Product> answer = productRepository.findById(id);
        if (answer.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new Exception("No existe el producto a eliminar");

        }
    }

    @Override
    public List<ProductDto> getAll() {

        List<ProductDto> productDtos= productMapper.productListToProductDtos(productRepository.findAll());
        return productDtos;
    }

}