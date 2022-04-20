
package com.ecommerce.changuito.service;


import com.ecommerce.changuito.dto.CategoryDto;
import com.ecommerce.changuito.error.ErrorService;

import java.util.List;


public interface CategoryService {
    
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(Long id, CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto getById(Long id) throws ErrorService;
    public void delete(Long id) throws ErrorService;
}
