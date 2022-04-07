package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dtos.MerchandiserDTO;
import com.ecommerce.changuito.entities.MerchandiserEntity;
import com.ecommerce.changuito.entities.City.CityEnum;

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

    public MerchandiserEntity merchandiserDto2Entity(MerchandiserDTO dto){
        MerchandiserEntity entity = modelMapper.map(dto, MerchandiserEntity.class);
        entity.setCreationDate(LocalDate.now());
        System.out.println("*** Merchandise DTO to Entity ***");
        System.out.println(dto);
        System.out.println(entity);
        return entity;
    }

    public MerchandiserDTO merchandiserEntity2Dto(MerchandiserEntity entity){
        MerchandiserDTO dto = modelMapper.map(entity, MerchandiserDTO.class);
        dto.setCreationDate(entity.getCreationDate().toString());
        System.out.println("*** Merchandise Entity to DTO ***");
        System.out.println(entity);
        System.out.println(dto);
        return dto;
    }

    public List<MerchandiserDTO> merchandiserEntityList2DtosList(List<MerchandiserEntity> entities) {
        List<MerchandiserDTO> dtos = new ArrayList<>();
        for (MerchandiserEntity entity: entities) {
            dtos.add(this.merchandiserEntity2Dto(entity));
        }
        return dtos;
    }

  
    

}