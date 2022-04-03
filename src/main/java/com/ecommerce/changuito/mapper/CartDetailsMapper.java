package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dtos.CartDetailsDTO;
import com.ecommerce.changuito.entities.CartDetailsEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CartDetailsMapper {
    
    private ModelMapper modelMapper = new ModelMapper();

    public CartDetailsDTO cartDetailsEntity2Dto(CartDetailsEntity entity){
        CartDetailsDTO dto = modelMapper.map(entity, CartDetailsDTO.class);
        System.out.println("***CartDetails Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto;   
    }

    public CartDetailsEntity cartDetailsDto2Entity(CartDetailsDTO dto) {
        CartDetailsEntity entity = modelMapper.map(dto, CartDetailsEntity.class);
        System.out.println("***Cart DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }
}

