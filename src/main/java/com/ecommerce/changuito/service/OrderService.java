package com.ecommerce.changuito.service;

import java.util.List;


public interface OrderService {
    com.ecommerce.changuito.dto.OrderDto add(com.ecommerce.changuito.dto.OrderDto dto);
    List<com.ecommerce.changuito.dto.OrderDto> getAll();
    void deleteOrder(Long id);
    com.ecommerce.changuito.dto.OrderDto update(Long id, com.ecommerce.changuito.dto.OrderDto dto);
}
