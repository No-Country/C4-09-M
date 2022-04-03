package com.ecommerce.changuito.repositories;

import com.ecommerce.changuito.entities.CartEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Long>{
    
}
