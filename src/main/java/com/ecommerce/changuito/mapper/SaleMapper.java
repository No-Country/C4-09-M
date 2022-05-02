package com.ecommerce.changuito.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.changuito.dto.SaleDto;
import com.ecommerce.changuito.entity.SaleEntity;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper {
    
    private ModelMapper modelMapper = new ModelMapper();

    public SaleDto SaleEntity2Dto(SaleEntity entity){
        SaleDto dto = modelMapper.map(entity, SaleDto.class);
        System.out.println("***Sale Entity to DTO***");
        System.out.println(entity);
        System.out.println(dto);
        return dto;   
    }

    public SaleEntity SaleDto2Entity(SaleDto dto) {
        SaleEntity entity = modelMapper.map(dto, SaleEntity.class);
        System.out.println("***Sale DTO to Entity***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

    public List<SaleDto> SaleEntityList2DtosList(List<SaleEntity> entities) {
        List<SaleDto> dtos = new ArrayList<>();
        for (SaleEntity entity: entities) {
            dtos.add(this.SaleEntity2Dto(entity));
        }
        return dtos;
    }



}

