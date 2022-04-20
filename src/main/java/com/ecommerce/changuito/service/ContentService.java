
package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.ContentDto;
import com.ecommerce.changuito.error.ErrorService;

import java.util.List;


public interface ContentService {
    
    ContentDto save(ContentDto contentDto);
    public void delete(Long id)throws ErrorService;
    ContentDto update(Long id, ContentDto contentDto)throws ErrorService;
    ContentDto getById(Long id) throws ErrorService;
    List<ContentDto> getAll();
}
