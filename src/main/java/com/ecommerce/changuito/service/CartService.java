package com.ecommerce.changuito.service;

import java.util.List;

import com.ecommerce.changuito.dto.CartDTO;

public interface CartService {
    CartDTO add(CartDTO dto);
    List<CartDTO> getAll();
    void deleteCart(Long id);
    CartDTO update(Long id, CartDTO dto);
    
}
