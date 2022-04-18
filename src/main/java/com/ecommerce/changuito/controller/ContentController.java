
package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.ContentDto;
import com.ecommerce.changuito.service.impl.ContentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class ContentController {
    
    private ContentServiceImpl contentService;
    
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ContentDto contentDto){
      ContentDto contentDto1 = contentService.save(contentDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(contentDto1);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try {
            contentService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
