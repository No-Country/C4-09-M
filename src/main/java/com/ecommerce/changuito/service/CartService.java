package com.ecommerce.changuito.service;
import com.ecommerce.changuito.dto.CartDto;
import java.util.List;

public interface CartService {
    CartDto add(CartDto dto);
    List<CartDto> getAll();
    void deleteCart(Long id);
    CartDto update(Long id, CartDto dto);
    
}
