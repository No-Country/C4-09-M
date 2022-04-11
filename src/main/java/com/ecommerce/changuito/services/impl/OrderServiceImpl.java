package com.ecommerce.changuito.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.ecommerce.changuito.dtos.OrderDTO;
import com.ecommerce.changuito.entities.OrderEntity;
import com.ecommerce.changuito.entities.CartEntity;
import com.ecommerce.changuito.mapper.OrderMapper;
import com.ecommerce.changuito.repositories.OrderRepository;
import com.ecommerce.changuito.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper OrderMapper;

    @Autowired
    private OrderRepository OrderRepository;

    @Override
    @Transactional
    public OrderDTO add(OrderDTO dto) {
        OrderEntity entity = OrderMapper.OrderDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = OrderRepository.save(entity);
        OrderDTO result = OrderMapper.OrderEntity2Dto(entity);
        return result;
    }

    @Override
    @Transactional
    public List<OrderDTO> getAll() {
        List<OrderDTO> results;
        List<OrderEntity> entities = OrderRepository.findAll();
        results = OrderMapper.OrderEntityList2DtosList(entities);
        return results;
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        OrderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public OrderDTO update(Long id, OrderDTO dto) {
        OrderEntity entity = OrderRepository.getById(id);
        if (entity != null){
            entity = OrderMapper.OrderDto2Entity(dto);
            entity = OrderRepository.save(entity);
            OrderDTO result = OrderMapper.OrderEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }
    }



}
