package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dto.MerchandiserDto;

import com.ecommerce.changuito.entity.MerchandiserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class MerchandiserMapper {

    private ModelMapper modelMapper = new ModelMapper();

    private static LocalDate string2LocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateFormatted = LocalDate.parse(date, formatter);
        return dateFormatted;
    }
    public MerchandiserEntity merchandiserDto2Entity(MerchandiserDto dto){
        System.out.println("*** Merchandiser DTO to Entity ***");
        MerchandiserEntity entity = modelMapper.map(dto, MerchandiserEntity.class);
        return entity;
    }

    public MerchandiserDto merchandiserEntity2Dto(MerchandiserEntity entity){
        MerchandiserDto dto = modelMapper.map(entity, MerchandiserDto.class);
        dto.setCreationDate(entity.getCreationDate().toString());
        System.out.println("*** Merchandiser Entity to DTO ***");
        return dto;
    }

    public List<MerchandiserDto> merchandiserEntityList2Dtos(List<MerchandiserEntity> entities){
        List<MerchandiserDto> dtos = new ArrayList<>();
        for (MerchandiserEntity entity: entities) {
            dtos.add(this.merchandiserEntity2Dto(entity));
        }
        return dtos;
    }

}
