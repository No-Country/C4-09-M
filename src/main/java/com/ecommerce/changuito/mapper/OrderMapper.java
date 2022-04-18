package com.ecommerce.changuito.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.changuito.dto.OrderDTO;
import com.ecommerce.changuito.entity.OrderEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    
    private ModelMapper modelMapper = new ModelMapper();

    public OrderDTO OrderEntity2Dto(OrderEntity entity){
        OrderDTO dto = modelMapper.map(entity, OrderDTO.class);
        System.out.println("***Order Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto;   
    }

    public OrderEntity OrderDto2Entity(OrderDTO dto) {
        OrderEntity entity = modelMapper.map(dto, OrderEntity.class);
        System.out.println("***Cart DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

    public List<OrderDTO> OrderEntityList2DtosList(List<OrderEntity> entities) {
        List<OrderDTO> dtos = new ArrayList<>();
        for (OrderEntity entity: entities) {
            dtos.add(this.OrderEntity2Dto(entity));
        }
        return dtos;
    }



}

