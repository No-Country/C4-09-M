
package com.ecommerce.changuito.Repositories;

import com.ecommerce.changuito.Entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    
}
