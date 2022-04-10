package com.ecommerce.changuito.services;

import java.util.List;

import com.ecommerce.changuito.dtos.OrderDTO;



public interface OrderService {
    OrderDTO add(OrderDTO dto);
    List<OrderDTO> getAll();
    void deleteOrder(Long id);
    OrderDTO update(Long id, OrderDTO dto);
}
