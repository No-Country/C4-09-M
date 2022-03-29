package com.ecommerce.changuito.repositories;

import com.ecommerce.changuito.entities.MerchandiserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiserRepo extends JpaRepository<MerchandiserEntity, Long> {
}
