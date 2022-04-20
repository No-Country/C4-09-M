package com.ecommerce.changuito.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.ecommerce.changuito.dto.CartDTO;
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
    public CartDTO add(CartDTO dto) {
        CartEntity entity = cartMapper.cartDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = cartRepository.save(entity);
        CartDTO result = cartMapper.cartEntity2Dto(entity);
        return result;
    }

    @Override
    public List<CartDTO> getAll() {
        List<CartDTO> results;
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
    public CartDTO update(Long id, CartDTO dto) {
        CartEntity entity = cartRepository.getById(id);
        if (entity != null){
            entity = cartMapper.cartDto2Entity(dto);
            entity = cartRepository.save(entity);
            CartDTO result = cartMapper.cartEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }
    }
}
