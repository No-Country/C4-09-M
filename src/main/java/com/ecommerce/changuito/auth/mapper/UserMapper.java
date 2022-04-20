package com.ecommerce.changuito.auth.mapper;

import com.ecommerce.changuito.auth.dto.UserDTO;
import com.ecommerce.changuito.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public UserEntity userDto2UserEntity(UserDTO dto){
        UserEntity entity = modelMapper.map(dto, UserEntity.class);
        return entity;
    }

    public UserDTO userEntity2UserDto(UserEntity entity){
        UserDTO dto = modelMapper.map(entity, UserDTO.class);
        return dto;
    }
}
