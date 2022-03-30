package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Entities.Product;
import com.ecommerce.changuito.Errors.ErrorService;
import com.ecommerce.changuito.Repositories.ProductRepository;
import java.io.IOException;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void createProduct(String brand, String name, String description, Double content, MultipartFile image, Double price, Integer quantity) throws ErrorService, IOException {

        Product product = new Product();
        validation(brand, name, description, content, image, price, quantity);

        product.setBrand(brand);
        product.setName(name);
        product.setDescription(description);
        product.setContent(content);
        product.setImage(image.getBytes());
        product.setPrice(price);
        product.setQuantity(quantity);
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Long id, String brand, String name, String description, Double content, MultipartFile image, Double price, Integer quantity) throws IOException, ErrorService {
        Optional<Product> answer = productRepository.findById(id);
        if (answer.isPresent()) {
            Product product = answer.get();
            validation(brand, name, description, content, image, price, quantity);
            product.setBrand(brand);
            product.setName(name);
            product.setDescription(description);
            product.setContent(content);
            product.setImage(image.getBytes());
            product.setPrice(price);
            product.setQuantity(quantity);
            productRepository.save(product);
        } else {
            throw new ErrorService("El producto a modificar no existe");
        }

    }

    public void validation(String brand, String name, String description, Double content, MultipartFile image, Double price, Integer quantity) throws ErrorService {

        if (brand == null || brand.isEmpty()) {
            throw new ErrorService("El nombre de la marca no puede ser nulo o estar vacio");
        }
        if (name == null || name.isEmpty()) {
            throw new ErrorService("El nombre del producto no puede ser nulo o estar vacio");
        }
        if (description == null || description.isEmpty()) {
            throw new ErrorService("La descripcion no puede ser nula o estar vacio");
        }
        if (content == null) {
            throw new ErrorService("El contenido del producto no puede ser nulo");
        }
        if (image == null || image.isEmpty()) {
            throw new ErrorService("La imagen del producto no puede ser nula o estar vacia");
        }
        if (price == null) {
            throw new ErrorService("El precio del producto no puede ser nulo ");
        }
        if (price == null) {
            throw new ErrorService("La cantidad disponible del producto no debe ser nula");
        }

    }
    
    @Transactional
    public void deleteProduct(Long id){
        
        productRepository.deleteById(id);
    }
}
