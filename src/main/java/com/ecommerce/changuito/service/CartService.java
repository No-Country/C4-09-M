package com.ecommerce.changuito.service;

import java.util.List;

public interface CartService {
    com.ecommerce.changuito.dto.CartDto add(com.ecommerce.changuito.dto.CartDto dto);
    List<com.ecommerce.changuito.dto.CartDto> getAll();
    void deleteCart(Long id);
    com.ecommerce.changuito.dto.CartDto update(Long id, com.ecommerce.changuito.dto.CartDto dto);
    
}
