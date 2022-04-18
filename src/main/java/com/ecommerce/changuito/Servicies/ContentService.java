
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.ContentDto;
import com.ecommerce.changuito.Errors.ErrorService;
import java.util.List;


public interface ContentService {
    
    ContentDto save(ContentDto contentDto);
    public void delete(Long id)throws ErrorService;
    ContentDto update(Long id, ContentDto contentDto)throws ErrorService;
    ContentDto getById(Long id) throws ErrorService;
    List<ContentDto> getAll();
}
