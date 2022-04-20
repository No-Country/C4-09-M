
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.CategoryDto;
import com.ecommerce.changuito.Entities.Category;
import com.ecommerce.changuito.Errors.ErrorService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryService {
    
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(Long id, CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto getById(Long id) throws  ErrorService;
    public void delete(Long id) throws ErrorService;
    public Page<Category> searchPage(String q, Pageable pageable);
    public Page<Category> orderByAsc(Pageable pageable);
    public Page<Category> orderByDesc(Pageable pageable);
    
}
