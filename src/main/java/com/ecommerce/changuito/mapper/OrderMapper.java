package com.ecommerce.changuito.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.changuito.entity.OrderEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    
    private ModelMapper modelMapper = new ModelMapper();

    public com.ecommerce.changuito.dto.OrderDto OrderEntity2Dto(OrderEntity entity){
        com.ecommerce.changuito.dto.OrderDto dto = modelMapper.map(entity, com.ecommerce.changuito.dto.OrderDto.class);
        System.out.println("***Order Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto;   
    }

    public OrderEntity OrderDto2Entity(com.ecommerce.changuito.dto.OrderDto dto) {
        OrderEntity entity = modelMapper.map(dto, OrderEntity.class);
        System.out.println("***Cart DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

    public List<com.ecommerce.changuito.dto.OrderDto> OrderEntityList2DtosList(List<OrderEntity> entities) {
        List<com.ecommerce.changuito.dto.OrderDto> dtos = new ArrayList<>();
        for (OrderEntity entity: entities) {
            dtos.add(this.OrderEntity2Dto(entity));
        }
        return dtos;
    }



}

