package com.ecommerce.changuito.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.changuito.entity.CartEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    private ModelMapper modelMapper = new ModelMapper();
    
    public com.ecommerce.changuito.dto.CartDto cartEntity2Dto(CartEntity entity){
        com.ecommerce.changuito.dto.CartDto dto = modelMapper.map(entity, com.ecommerce.changuito.dto.CartDto.class);
        System.out.println("***Cart Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto; 
    }

    public CartEntity cartDto2Entity(com.ecommerce.changuito.dto.CartDto dto) {
        CartEntity entity = modelMapper.map(dto, CartEntity.class);
        System.out.println("***Cart DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

public List<com.ecommerce.changuito.dto.CartDto> cartEntityList2DtosList(List<CartEntity> entities) {
    List<com.ecommerce.changuito.dto.CartDto> dtos = new ArrayList<>();
    for (CartEntity entity: entities) {
        dtos.add(this.cartEntity2Dto(entity));
    }
    return dtos;
}


}
