package com.ecommerce.changuito.mapper;

import com.ecommerce.changuito.dto.ClientDto;
import com.ecommerce.changuito.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public ClientEntity clientDto2Entity(ClientDto dto){
        System.out.println("*** Client DTO to Entity ***");
        ClientEntity entity = modelMapper.map(dto, ClientEntity.class);
        entity.setBirthday(string2LocalDate(dto.getBirthday()));
        return  entity;
    }

    public ClientDto clientEntity2Dto(ClientEntity entity){
        System.out.println("*** Client Entity to DTO ***");
        ClientDto dto = modelMapper.map(entity, ClientDto.class);
        dto.setBirthday(entity.getBirthday().toString());

        //dto.setUpdated(entity.getUpdated().toString());
        return dto;
    }

    public List<ClientDto> clientEntityList2Dto(List<ClientEntity> entities){
        List<ClientDto> dtos = new ArrayList<>();
        for (ClientEntity entity: entities) {
            dtos.add(this.clientEntity2Dto(entity));
        }
        return dtos;
    }

    private static LocalDate string2LocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateFormatted = LocalDate.parse(date, formatter);
        return dateFormatted;
    }
}
