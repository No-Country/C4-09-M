package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Entities.Category;
import com.ecommerce.changuito.Errors.ErrorService;
import com.ecommerce.changuito.Repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void createCategory(String name) throws ErrorService {

        validation(name);
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }

    @Transactional
    public void updateCategory(Long id, String name) throws ErrorService {
        Optional<Category> answer = categoryRepository.findById(id);
        if (answer.isPresent()) {
            Category category = answer.get();
            category.setName(name);
            categoryRepository.save(category);
        } else {
            throw new ErrorService("La categoria a eliminar no existe");
        }

    }
    
    @Transactional
    public void deleteCategory(Long id){
        
        categoryRepository.deleteById(id);
    }
    
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void validation(String name) throws ErrorService {

        if (name == null || name.isEmpty()) {
            throw new ErrorService("El nonmbre de la categoria no puede ser nulo o vacio");
        }
    }
}
