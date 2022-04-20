package com.ecommerce.changuito.controller;


import com.ecommerce.changuito.dto.CategoryDto;
import com.ecommerce.changuito.error.ErrorService;
import com.ecommerce.changuito.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.getAll());
    }

    @PostMapping("save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto categoryDto1 = categoryService.save(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto) {

        CategoryDto categoryDto1 = categoryService.update(id, categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.getById(id));
        } catch (ErrorService ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
