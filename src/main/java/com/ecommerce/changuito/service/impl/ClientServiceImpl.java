package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.dto.ClientDto;
import com.ecommerce.changuito.entity.ClientEntity;
import com.ecommerce.changuito.mapper.ClientMapper;
import com.ecommerce.changuito.repository.ClientRepository;
import com.ecommerce.changuito.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    @Transactional
    public ClientDto save(ClientDto dto) {
        ClientEntity entity = clientMapper.clientDto2Entity(dto);
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
