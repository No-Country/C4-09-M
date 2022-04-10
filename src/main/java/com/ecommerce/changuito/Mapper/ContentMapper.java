
package com.ecommerce.changuito.Mapper;

import com.ecommerce.changuito.Dto.ContentDto;
import com.ecommerce.changuito.Entities.Category;
import com.ecommerce.changuito.Entities.Content;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContentMapper {
    
    private ModelMapper modelMapper= new ModelMapper();
    
    public Content contentDtoToContent( ContentDto contentDto){
        Content content= modelMapper.map(contentDto, Content.class);
        return content;
    }
    
    public ContentDto contentToContentDto(Content content){
        ContentDto contentDto= modelMapper.map(content, ContentDto.class);
        return contentDto;
    }
    
    public List<ContentDto> contentListToDto(List<Content> contents){
        List<ContentDto> contentDtos= new ArrayList();
        for (Content content : contents) {
            contentDtos.add(this.contentToContentDto(content));
        }
        return contentDtos;
    }
}
