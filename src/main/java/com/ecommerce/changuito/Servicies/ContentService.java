
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.ContentDto;
import java.util.List;


public interface ContentService {
    
    ContentDto save();
    public void delete(Long id);
    ContentDto update(Long id, ContentDto contentDto);
    List<ContentDto> getAll();
}
