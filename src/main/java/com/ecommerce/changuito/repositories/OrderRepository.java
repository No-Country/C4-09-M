package com.ecommerce.changuito.repositories;

import com.ecommerce.changuito.entities.OrderEntity;
import com.ecommerce.changuito.entities.CartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

	OrderEntity save(OrderEntity entity);
   
}
