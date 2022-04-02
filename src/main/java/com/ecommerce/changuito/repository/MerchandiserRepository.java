package com.ecommerce.changuito.repository;

import com.ecommerce.changuito.entity.MerchandiserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiserRepository extends JpaRepository<MerchandiserEntity, Long> {
}