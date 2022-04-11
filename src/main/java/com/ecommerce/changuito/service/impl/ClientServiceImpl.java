package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.auth.mapper.UserMapper;
import com.ecommerce.changuito.auth.service.UserDetailsCustomService;
import com.ecommerce.changuito.dto.ClientDto;
import com.ecommerce.changuito.entity.ClientEntity;
import com.ecommerce.changuito.entity.UserEntity;
import com.ecommerce.changuito.mapper.ClientMapper;
import com.ecommerce.changuito.repository.ClientRepository;
import com.ecommerce.changuito.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public ClientDto save(ClientDto dto) throws Exception{
        ClientEntity entity = clientMapper.clientDto2Entity(dto);
        entity.setUser(userMapper.userDto2UserEntity(dto.getUser()));
        entity.getUser().setPassword(bCryptPasswordEncoder.encode(entity.getUser().getPassword()));
        UserEntity userEntity = userDetailsCustomService.findByUsername(entity.getUser().getUsername());
        if (userEntity != null){
            throw new Exception("Username alredy exist!");
        }
        ClientEntity entitySaved = clientRepository.save(entity);
        ClientDto result = clientMapper.clientEntity2Dto(entitySaved);
        return result;
    }

    @Override
    public List<ClientDto> getAll() {
        List<ClientEntity> entities = clientRepository.findAll();
        return clientMapper.clientEntityList2Dto(entities);
    }
}
