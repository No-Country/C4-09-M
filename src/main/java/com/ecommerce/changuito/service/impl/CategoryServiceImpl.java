
package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.dto.CategoryDto;
import com.ecommerce.changuito.entity.Category;
import com.ecommerce.changuito.mapper.CategoryMapper;
import com.ecommerce.changuito.repository.CategoryRepository;
import com.ecommerce.changuito.service.CategoryService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDto save( CategoryDto categoryDto) {
        
        Category category= categoryMapper.categoryDtoToCategory(categoryDto);
        Category categoryRepo= categoryRepository.save(category);
        return categoryMapper.categoryToCategoryDto(categoryRepo);
    }

    @Override
    @Transactional
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        
        Optional<Category> answer= categoryRepository.findById(id);
        if (answer.isPresent()) {
            Category category= answer.get();
            category= categoryMapper.categoryDtoToCategory(categoryDto);
            category= categoryRepository.save(category);
            return categoryMapper.categoryToCategoryDto(category);
        } else {
            return null;
        }
    }

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtos= categoryMapper.categoryListToDto(categoryRepository.findAll());
        return categoryDtos;
    }

    @Override
    public void delete(Long id) throws Exception {
        
        Optional<Category> answer= categoryRepository.findById(id);
        if (answer.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new Exception("No existe categoria para eliminar");
        }
    }
}
