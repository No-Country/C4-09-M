package com.ecommerce.changuito.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import com.ecommerce.changuito.dto.OrderDto;
import com.ecommerce.changuito.entity.OrderEntity;
import com.ecommerce.changuito.mapper.OrderMapper;
import com.ecommerce.changuito.repository.OrderRepository;
import com.ecommerce.changuito.service.OrderService;

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
    public com.ecommerce.changuito.dto.OrderDto add(com.ecommerce.changuito.dto.OrderDto dto) {
        OrderEntity entity = OrderMapper.OrderDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = OrderRepository.save(entity);
        com.ecommerce.changuito.dto.OrderDto result = OrderMapper.OrderEntity2Dto(entity);
        return result;
    }

    @Override
    @Transactional
    public List<OrderDto> getAll() {
        List<OrderDto> results;
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
    public OrderDto update(Long id, OrderDto dto) {
        OrderEntity entity = OrderRepository.getById(id);
        if (entity != null){
            entity = OrderMapper.OrderDto2Entity(dto);
            entity = OrderRepository.save(entity);
            OrderDto result = OrderMapper.OrderEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }
    }



}
