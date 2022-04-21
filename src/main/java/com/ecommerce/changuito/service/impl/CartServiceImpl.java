package com.ecommerce.changuito.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import com.ecommerce.changuito.dto.CartDto;
import com.ecommerce.changuito.entity.CartEntity;
import com.ecommerce.changuito.mapper.CartMapper;
import com.ecommerce.changuito.repository.CartRepository;
import com.ecommerce.changuito.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartRepository cartRepository;

    @Override
    @Transactional
    public com.ecommerce.changuito.dto.CartDto add(@Valid CartDto dto) {
        CartEntity entity = cartMapper.cartDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = cartRepository.save(entity);
        CartDto result = cartMapper.cartEntity2Dto(entity);
        return result;
    }

    @Override
    public List<CartDto> getAll() {
        List<CartDto> results;
        List<CartEntity> entities = cartRepository.findAll();
        results = cartMapper.cartEntityList2DtosList(entities);
        return results;
    }

    @Override
    @Transactional
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CartDto update(Long id, CartDto dto) {
        CartEntity entity = cartRepository.getById(id);
        if (entity != null){
            entity = cartMapper.cartDto2Entity(dto);
            entity = cartRepository.save(entity);
            CartDto result = cartMapper.cartEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }
    }
}
