package com.ecommerce.changuito.services;

import com.ecommerce.changuito.dtos.MerchandiserDTO;

import java.util.List;

public interface MerchandiserService {

    MerchandiserDTO add(MerchandiserDTO entity);
    List<MerchandiserDTO> getAll();
    void deleteMerchandiser(Long id);
    MerchandiserDTO update(Long id, MerchandiserDTO dto);
}