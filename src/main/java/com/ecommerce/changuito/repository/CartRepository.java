package com.ecommerce.changuito.repository;

import com.ecommerce.changuito.entity.CartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long>{
    
}
