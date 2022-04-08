
package com.ecommerce.changuito.Servicies.Impl;

import com.ecommerce.changuito.Dto.ContentDto;
import com.ecommerce.changuito.Entities.Content;
import com.ecommerce.changuito.Mapper.ContentMapper;
import com.ecommerce.changuito.Repositories.ContentRepository;
import com.ecommerce.changuito.Servicies.ContentService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService{
    
    @Autowired
    private ContentMapper contentMapper;
    
    @Autowired
    private ContentRepository contentRepository;

    @Override
    @Transactional
    public ContentDto save(ContentDto contentDto) {
        
        Content content= contentMapper.contentDtoToContent(contentDto);
        Content contentRepo= contentRepository.save(content);
        return contentMapper.contentToContentDto(contentRepo);
    }

    @Override
    public void delete(Long id) throws Exception{

        Optional<Content> answer= contentRepository.findById(id);
        if (answer.isPresent()) {
            contentRepository.deleteById(id);
        } else {
             throw  new Exception("No existe contenido a eliminar");
        }
    }

    @Override
    public ContentDto update(Long id, ContentDto contentDto) {
        
        Optional<Content> answer = contentRepository.findById(id);
        if (answer.isPresent()) {
            Content content= answer.get();
            return contentMapper.contentToContentDto(contentRepository.save(content));
        } else {
            return null;
        }
    }

    @Override
    public List<ContentDto> getAll() {
        
        List<ContentDto> contentDtos= contentMapper.contentListToDto(contentRepository.findAll());
        return contentDtos;
    }
    
}
