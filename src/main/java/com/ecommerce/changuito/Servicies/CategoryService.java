
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.CategoryDto;
import com.ecommerce.changuito.Errors.ErrorService;
import java.util.List;


public interface CategoryService {
    
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(Long id, CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto getById(Long id) throws  ErrorService;
    public void delete(Long id) throws ErrorService;
}
