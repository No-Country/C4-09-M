
package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.ContentDto;
import java.util.List;


public interface ContentService {
    
    ContentDto save(ContentDto contentDto);
    public void delete(Long id)throws Exception;
    ContentDto update(Long id, ContentDto contentDto);
    List<ContentDto> getAll();
}
