
package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.CategoryDto;

import com.ecommerce.changuito.service.impl.CategoryServiceImpl;
import javax.validation.Valid;

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
@RequestMapping("category")
public class CategoryController {
    
    @Autowired
    private CategoryServiceImpl categoryService;
    
    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.getAll());
    }
    
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getOne(@PathVariable Long id){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
    @PostMapping("save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
      CategoryDto  categoryDto1 = categoryService.save(categoryDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto1);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id,@Valid @RequestBody CategoryDto categoryDto){
        
      CategoryDto  categoryDto1 = categoryService.update(id, categoryDto);
      return ResponseEntity.status(HttpStatus.OK).body(categoryDto1);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try {
            categoryService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
