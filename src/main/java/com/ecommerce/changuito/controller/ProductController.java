
package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.ProductDto;
import com.ecommerce.changuito.error.ErrorService;
import com.ecommerce.changuito.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    private ProductServiceImpl productService;
    
    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getAll());
    }
    
    @PostMapping("save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) throws ErrorService {
      ProductDto productDto1;
        productDto1 = productService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try {
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(id, productDto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getById(id));
    }
    
    
    
}
