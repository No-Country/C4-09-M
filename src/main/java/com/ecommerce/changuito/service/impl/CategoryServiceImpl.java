
package com.ecommerce.changuito.service.impl;


import com.ecommerce.changuito.dto.CategoryDto;
import com.ecommerce.changuito.entity.Category;
import com.ecommerce.changuito.error.ErrorService;
import com.ecommerce.changuito.mapper.CategoryMapper;
import com.ecommerce.changuito.repository.CategoryRepository;
import com.ecommerce.changuito.service.CategoryService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Transactional
    public void delete(Long id) throws ErrorService {
        
        Optional<Category> answer= categoryRepository.findById(id);
        if (answer.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new ErrorService("No existe categoria para eliminar");
        }
    }

    @Override
    public CategoryDto getById(Long id) throws ErrorService {
        
        Optional<Category> answer= categoryRepository.findById(id);
        if (answer.isPresent()) {
            Category category=answer.get();
            return categoryMapper.categoryToCategoryDto(category);
        } else {
             throw new ErrorService("No existe la categoria buscada");
        }
    }
    @Override
    public Page<Category> searchPage(String q, Pageable pageable) {
        return categoryRepository.searchPage(q, pageable);
    }

    @Override
    public Page<Category> orderByAsc(Pageable pageable) {
        return categoryRepository.orderByAsc(pageable);
    }

    @Override
    public Page<Category> orderByDesc(Pageable pageable) {
        return categoryRepository.orderByDesc(pageable);
    }
}
