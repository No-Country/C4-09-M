package com.ecommerce.changuito.mapper;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.changuito.dto.CartDto;
import com.ecommerce.changuito.entity.CartEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    private ModelMapper modelMapper = new ModelMapper();
    
    public CartDto cartEntity2Dto(CartEntity entity){
        CartDto dto = modelMapper.map(entity, CartDto.class);
        System.out.println("***Cart Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto; 
    }

    public CartEntity cartDto2Entity(CartDto dto) {
        CartEntity entity = modelMapper.map(dto, CartEntity.class);
        System.out.println("***Cart DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

public List<CartDto> cartEntityList2DtosList(List<CartEntity> entities) {
    List<CartDto> dtos = new ArrayList<>();
    for (CartEntity entity: entities) {
        dtos.add(this.cartEntity2Dto(entity));
    }
    return dtos;
}


}
