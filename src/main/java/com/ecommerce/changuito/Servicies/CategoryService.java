
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.CategoryDto;
import java.util.List;


public interface CategoryService {
    
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(Long id, CategoryDto categoryDto);
    List<CategoryDto> getAll();
    public void delete(Long id) throws Exception;
}
