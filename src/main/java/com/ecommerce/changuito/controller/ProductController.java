
package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.ProductDto;
import com.ecommerce.changuito.error.ErrorService;
import com.ecommerce.changuito.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

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
    

    @GetMapping("paged")
    public ResponseEntity<?>getAllPage(Pageable pageable){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.getAllPage(pageable));
    }
    
    @PostMapping("save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
      ProductDto productDto1;
        try {
            productDto1 = productService.save(productDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
        } catch (ErrorService ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
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
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(id, productDto));
        } catch (ErrorService ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.getById(id));
        } catch (ErrorService ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    
   @GetMapping("search")
    public ResponseEntity<?> searchPage(String q, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.searchPage(q, pageable));
    }

    @GetMapping("brandAsc")
    public ResponseEntity<?> brandOrderByAsc( Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.brandOrderByAsc(pageable));
    }

    @GetMapping("brandDesc")
    public ResponseEntity<?> brandOrderByDesc( Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.brandOrderByDesc(pageable));
    }

    @GetMapping("nameAsc")
    public ResponseEntity<?> nameOrderByAsc( Pageable pageable) {
         return ResponseEntity.status(HttpStatus.CREATED).body(productService.nameOrderByAsc(pageable));
    }

    @GetMapping("nameDesc")
    public ResponseEntity<?> nameOrderByDesc( Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.nameOrderByDesc(pageable));
    }

    @GetMapping("wholeAsc")
    public ResponseEntity<?> wholesaler_priceOrderByAsc( Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.wholesaler_priceOrderByAsc(pageable));
    }

    @GetMapping("wholeDesc")
    public ResponseEntity<?> wholesaler_priceOrderByDesc(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.wholesaler_priceOrderByDesc(pageable));
    }

    @GetMapping("retailAsc")
    public ResponseEntity<?> retail_priceOrderByAsc( Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.retail_priceOrderByAsc(pageable));
    }

    @GetMapping("retailDesc")
    public ResponseEntity<?> retail_priceOrderByDesc( Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.retail_priceOrderByDesc(pageable));
    }
    
    @GetMapping("productCategory/{id}")
    public ResponseEntity<?> productForCategory(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.productForCategory(id,pageable));
    }
    
    
    
}
