
package com.ecommerce.changuito.Servicies.Impl;

import com.ecommerce.changuito.Dto.ContentDto;
import com.ecommerce.changuito.Entities.Content;
import com.ecommerce.changuito.Errors.ErrorService;
import com.ecommerce.changuito.Mapper.ContentMapper;
import com.ecommerce.changuito.Repositories.ContentRepository;
import com.ecommerce.changuito.Servicies.ContentService;
import java.util.List;
import java.util.Optional;
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
    @Transactional
    public void delete(Long id) throws ErrorService{

        Optional<Content> answer= contentRepository.findById(id);
        if (answer.isPresent()) {
            contentRepository.deleteById(id);
        } else {
             throw  new ErrorService("No existe contenido a eliminar");
        }
    }

    @Override
    @Transactional
    public ContentDto update(Long id, ContentDto contentDto)throws ErrorService{
        
        Optional<Content> answer = contentRepository.findById(id);
        if (answer.isPresent()) {
            Content content= answer.get();
            content= contentMapper.contentDtoToContent(contentDto);
            content= contentRepository.save(content);
            return contentMapper.contentToContentDto(content);
            
        } else {
            throw new ErrorService("No existe la unidad de medida a modificar");
        }
    }

    @Override
    public List<ContentDto> getAll() {
        
        List<ContentDto> contentDtos= contentMapper.contentListToDto(contentRepository.findAll());
        return contentDtos;
    }

    @Override
    public ContentDto getById(Long id) throws ErrorService {
        
        Optional<Content> answer= contentRepository.findById(id);
        if (answer.isPresent()) {
            Content content= answer.get();
            return contentMapper.contentToContentDto(content);
        } else {
            throw new ErrorService("No existe la unidad de medida buscada");
        }
    }
    
}
