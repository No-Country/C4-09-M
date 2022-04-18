package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.dto.ProductDto;
import com.ecommerce.changuito.entity.Product;
import com.ecommerce.changuito.mapper.ProductMapper;
import com.ecommerce.changuito.repository.ProductRepository;
import com.ecommerce.changuito.service.ProductService;
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
            throw new Exception("No exsite el producto a elimiar");

        }
    }

    @Override
    public List<ProductDto> getAll() {
        
        List<ProductDto> productDtos= productMapper.productListToDto(productRepository.findAll());
        return productDtos;
    }

}
