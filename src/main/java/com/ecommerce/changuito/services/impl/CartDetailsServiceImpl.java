package com.ecommerce.changuito.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.ecommerce.changuito.dtos.CartDetailsDTO;
import com.ecommerce.changuito.entities.CartDetailsEntity;
import com.ecommerce.changuito.mapper.CartDetailsMapper;
import com.ecommerce.changuito.repositories.CartDetailsRepo;
import com.ecommerce.changuito.services.CartDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDetailsServiceImpl implements CartDetailsService{

    @Autowired
    private CartDetailsMapper cartDetailsMapper;

    @Autowired
    private CartDetailsRepo cartDetailsRepo;

    @Override
    @Transactional
    public CartDetailsDTO add(CartDetailsDTO dto) {
        CartDetailsEntity entity = cartDetailsMapper.cartDetailsDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = cartDetailsRepo.save(entity);
        CartDetailsDTO result = cartDetailsMapper.cartDetailsEntity2Dto(entity);
        return result;

    
}

	@Override
	public List<CartDetailsDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
