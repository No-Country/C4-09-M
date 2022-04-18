
package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dto.CategoryDto;
import com.ecommerce.changuito.entity.Category;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    
    private ModelMapper modelMapper= new ModelMapper();
    
    public Category categoryDtoToCategory(CategoryDto categoryDto){
        
        Category category= modelMapper.map(categoryDto, Category.class);
        return category;
    }
    
    public CategoryDto categoryToCategoryDto(Category category){
        
        CategoryDto categoryDto= modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
    
    public List<CategoryDto> categoryListToDto(List<Category> categories){
        List<CategoryDto> categoryDtos= new ArrayList<>();
        for (Category category : categories) {
            categoryDtos.add(this.categoryToCategoryDto(category));
        }
        return categoryDtos;
    }
}

