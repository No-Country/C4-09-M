package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);
    List<ClientDto> getAll();

}
