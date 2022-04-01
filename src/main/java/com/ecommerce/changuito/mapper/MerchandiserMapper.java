package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.entity.MerchandiserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MerchandiserMapper {

    private ModelMapper modelMapper = new ModelMapper();

    private static LocalDate string2LocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateFormatted = LocalDate.parse(date, formatter);
        return dateFormatted;
    }

    public MerchandiserEntity merchandiserDto2Entity(MerchandiserDto dto){
        MerchandiserEntity entity = modelMapper.map(dto, MerchandiserEntity.class);
        entity.setCreationDate(LocalDate.now());
        System.out.println("*** Merchandiser DTO to Entity ***");
        return entity;
    }

    public MerchandiserDto merchandiserEntity2Dto(MerchandiserEntity entity){
        MerchandiserDto dto = modelMapper.map(entity, MerchandiserDto.class);
        dto.setCreationDate(entity.getCreationDate().toString());
        System.out.println("*** Merchandiser Entity to DTO ***");
        return dto;
    }
}
