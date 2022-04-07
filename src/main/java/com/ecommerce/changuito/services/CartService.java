package com.ecommerce.changuito.services;

import java.util.List;

import com.ecommerce.changuito.dtos.CartDTO;
import com.ecommerce.changuito.entities.CartEntity;

public interface CartService {
    CartDTO add(CartDTO dto);
    List<CartDTO> getAll();
    void deleteCart(Long id);
    CartDTO update(Long id, CartDTO dto);
    
}
