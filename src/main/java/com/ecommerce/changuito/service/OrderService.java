package com.ecommerce.changuito.service;

import java.util.List;

import com.ecommerce.changuito.dto.OrderDTO;



public interface OrderService {
    OrderDTO add(OrderDTO dto);
    List<OrderDTO> getAll();
    void deleteOrder(Long id);
    OrderDTO update(Long id, OrderDTO dto);
}
