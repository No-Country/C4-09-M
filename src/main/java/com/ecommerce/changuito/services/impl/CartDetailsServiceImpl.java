package com.ecommerce.changuito.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.ecommerce.changuito.dtos.CartDetailsDTO;
import com.ecommerce.changuito.entities.CartDetailsEntity;
import com.ecommerce.changuito.entities.CartEntity;
import com.ecommerce.changuito.mapper.CartDetailsMapper;
import com.ecommerce.changuito.repositories.CartDetailsRepository;
import com.ecommerce.changuito.services.CartDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDetailsServiceImpl implements CartDetailsService {

    @Autowired
    private CartDetailsMapper cartDetailsMapper;

    @Autowired
    private CartDetailsRepository cartDetailsRepository;

    @Override
    @Transactional
    public CartDetailsDTO add(CartDetailsDTO dto) {
        CartDetailsEntity entity = cartDetailsMapper.cartDetailsDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = cartDetailsRepository.save(entity);
        CartDetailsDTO result = cartDetailsMapper.cartDetailsEntity2Dto(entity);
        return result;
    }

    @Override
    @Transactional
    public List<CartDetailsDTO> getAll() {
        List<CartDetailsDTO> results;
        List<CartDetailsEntity> entities = cartDetailsRepository.findAll();
        results = cartDetailsMapper.cartDetailsEntityList2DtosList(entities);
        return results;
    }

    @Override
    @Transactional
    public void deleteCartDetails(Long id) {
        cartDetailsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CartDetailsDTO update(Long id, CartDetailsDTO dto) {
        CartDetailsEntity entity = cartDetailsRepository.getById(id);
        if (entity != null){
            entity = cartDetailsMapper.cartDetailsDto2Entity(dto);
            entity = cartDetailsRepository.save(entity);
            CartDetailsDTO result = cartDetailsMapper.cartDetailsEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }
    }



}
