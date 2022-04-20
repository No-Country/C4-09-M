package com.ecommerce.changuito.service.impl;


import com.ecommerce.changuito.dto.ProductDto;
import com.ecommerce.changuito.entity.Product;
import com.ecommerce.changuito.error.ErrorService;
import com.ecommerce.changuito.mapper.ProductMapper;
import com.ecommerce.changuito.repository.ProductRepository;
import com.ecommerce.changuito.service.ProductService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto)throws ErrorService{
        validation(productDto);
        Product product = productMapper.productDtoToProduct(productDto);
        Product productRepo = productRepository.save(product);
        return productMapper.productToProductDto(productRepo);
    }

    @Override
    @Transactional
    public ProductDto update(Long id, ProductDto productDto)throws ErrorService{
        Optional<Product> answer = productRepository.findById(id);
        if (answer.isPresent()) {
            validation(productDto);
            Product product = answer.get();
            product = productMapper.productDtoToProduct(productDto);
            product = productRepository.save(product);
            return productMapper.productToProductDto(product);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) throws ErrorService {
        Optional<Product> answer = productRepository.findById(id);
        if (answer.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ErrorService("No exsite el producto a elimiar");

        }
    }

    @Override
    public List<ProductDto> getAll() {
        
        List<ProductDto> productDtos= productMapper.productListToDto(productRepository.findAll());
        return productDtos;
    }
 
    @Override
    public ProductDto getById(Long id) throws ErrorService {
        Optional<Product> answer= productRepository.findById(id);
        if (answer.isPresent()) {
            Product product= answer.get();
            return productMapper.productToProductDto(product);
        } else {
            throw new ErrorService("El producto solicitado no existe");
        }
    }

    @Override
    public void validation(ProductDto productDto) throws ErrorService {
        
        if (productDto.getBrand()==null || productDto.getBrand().isEmpty()) {
            throw new ErrorService("La marca del producto no debe ser nulo o estar vacio");
        }
        if (productDto.getName()==null || productDto.getName().isEmpty()) {
            throw new ErrorService("El nombre del producto no debe ser nulo o estar vacio");
        }
        if (productDto.getDescription()==null || productDto.getDescription().isEmpty()) {
            throw new ErrorService("La descripcion del producto no debe ser nulo o estar vacio");
        }

//        if (productDto.getContentDto().getId()==null) {
//            throw new ErrorService("Debe elegir la unidad de medida del producto");
//        }
//        if (productDto.getContentDto().getName()== null) {
//            throw new ErrorService("El nombre de la unidad de medida no debe estar vacio");
//        }
        if (productDto.getWholesaler_price()==null) {
            throw new ErrorService("El precio mayorista del producto no debe ser nulo o estar vacio");
        }
        if (productDto.getRetail_price()==null) {
            throw new ErrorService("El precio minorista del producto no debe ser nulo o estar vacio");
        }
        if (productDto.getQuantity()==null) {
            throw new ErrorService("La cantidad del producto no debe ser nulo o estar vacio");
        }

//        if (productDto.getCategoryDto().getId()==null) {
//            throw new ErrorService("El rubro del producto no debe ser nulo o estar vacio");
//        }
//        if (productDto.getCategoryDto().getName()== null) {
//               throw new ErrorService("El nombre de la categoria del producto no puede estar vacio");
//            }
        if (productDto.getId_image()== null) {
            throw new ErrorService("La imagen no debe ser nula");
        }
        
    }


    @Override
    public Page<Product> getAllPage(Pageable pageable){
        
        return productRepository.findAllPage(pageable);
        
    }

    @Override
    public Page<Product> searchPage(String q, Pageable pageable) {
        return productRepository.searchPage(q, pageable);
    }

    @Override
    public Page<Product> brandOrderByAsc( Pageable pageable) {
        return productRepository.brandOrderByAsc(pageable);
    }

    @Override
    public Page<Product> brandOrderByDesc( Pageable pageable) {
        return productRepository.brandOrderByDesc(pageable);
    }

    @Override
    public Page<Product> nameOrderByAsc( Pageable pageable) {
        return productRepository.nameOrderByAsc(pageable);
    }

    @Override
    public Page<Product> nameOrderByDesc( Pageable pageable) {
        return productRepository.nameOrderByDesc(pageable);
    }

    @Override
    public Page<Product> wholesaler_priceOrderByAsc( Pageable pageable) {
        return productRepository.wholesaler_priceOrderByAsc(pageable);
    }

    @Override
    public Page<Product> wholesaler_priceOrderByDesc(Pageable pageable) {
        return productRepository.wholesaler_priceOrderByDesc(pageable);
    }

    @Override
    public Page<Product> retail_priceOrderByAsc( Pageable pageable) {
        return productRepository.retail_priceOrderByAsc(pageable);
    }

    @Override
    public Page<Product> retail_priceOrderByDesc( Pageable pageable) {
        return productRepository.retail_priceOrderByDesc(pageable);
    }

    @Override
    public Page<Product> productForCategory(Long id,Pageable pageable) {
        return productRepository.productForCategory(id, pageable);
    }


}
