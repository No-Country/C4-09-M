package com.ecommerce.changuito.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.ecommerce.changuito.dtos.CartDTO;
import com.ecommerce.changuito.entities.CartEntity;
import com.ecommerce.changuito.mapper.CartMapper;
import com.ecommerce.changuito.repositories.CartRepo;
import com.ecommerce.changuito.services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartRepo cartRepo;

    @Override
    @Transactional
    public CartDTO add(CartDTO dto) {
        CartEntity entity = cartMapper.cartDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = cartRepo.save(entity);
        CartDTO result = cartMapper.cartEntity2Dto(entity);
        return result;
    }

    @Override
    public List<CartDTO> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
