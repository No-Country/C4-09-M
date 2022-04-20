package com.ecommerce.changuito.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.changuito.dto.CartDTO;
import com.ecommerce.changuito.entity.CartEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    private ModelMapper modelMapper = new ModelMapper();
    
    public CartDTO cartEntity2Dto(CartEntity entity){
        CartDTO dto = modelMapper.map(entity, CartDTO.class);
        System.out.println("***Cart Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto; 
    }

    public CartEntity cartDto2Entity(CartDTO dto) {
        CartEntity entity = modelMapper.map(dto, CartEntity.class);
        System.out.println("***Cart DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

public List<CartDTO> cartEntityList2DtosList(List<CartEntity> entities) {
    List<CartDTO> dtos = new ArrayList<>();
    for (CartEntity entity: entities) {
        dtos.add(this.cartEntity2Dto(entity));
    }
    return dtos;
}


}
