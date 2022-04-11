package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.entity.MerchandiserEntity;

import java.util.List;

public interface MerchandiserService {

    MerchandiserDto add(MerchandiserDto entity);
    List<MerchandiserDto> getAll();
    MerchandiserDto update(Long id, MerchandiserDto dto);
    void delete(Long id);
}
