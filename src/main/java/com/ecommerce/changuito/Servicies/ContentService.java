
package com.ecommerce.changuito.Servicies;

import com.ecommerce.changuito.Dto.ContentDto;
import java.util.List;


public interface ContentService {
    
    ContentDto save(ContentDto contentDto);
    public void delete(Long id)throws Exception;
    ContentDto update(Long id, ContentDto contentDto);
    List<ContentDto> getAll();
}
