
package com.ecommerce.changuito.Controllers;

import com.ecommerce.changuito.Entities.Category;
import com.ecommerce.changuito.Errors.ErrorService;
import com.ecommerce.changuito.Servicies.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("all")
    public List<Category> getAll(){
        return categoryService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
        } catch (ErrorService e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
      Category  c = categoryService.saveCategory(category);
      return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
}
