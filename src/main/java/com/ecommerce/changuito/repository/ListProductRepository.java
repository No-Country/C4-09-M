
package com.ecommerce.changuito.repository;

import com.ecommerce.changuito.entity.ListProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListProductRepository extends JpaRepository<ListProduct, Long>{
    
}
