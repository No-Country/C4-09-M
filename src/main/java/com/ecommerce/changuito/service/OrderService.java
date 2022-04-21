package com.ecommerce.changuito.service;

import java.util.List;
import com.ecommerce.changuito.dto.OrderDto;

public interface OrderService {
    OrderDto add(OrderDto dto);
    List<OrderDto> getAll();
    void deleteOrder(Long id);
    OrderDto update(Long id, OrderDto dto);
}
