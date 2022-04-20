
package com.ecommerce.changuito.Repositories;

import com.ecommerce.changuito.Entities.Content;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    
    @Query(value = "select * from Content ",
            countQuery = "select count(*) from Content",
            nativeQuery = true)
    Page<Content> findAllPage(Pageable pageable);
    
    @Query(value = "select * from Content where name LIKE '%q%'",
            countQuery = "select count(*) from Content",
            nativeQuery = true)
    List<Content> search(@Param("q") String q);
    
    @Query(value = "select * from Content where name LIKE '%q%'", 
            countQuery = "select count(*) from Content",
            nativeQuery = true)
    Page<Content> search(@Param("q") String q, Pageable pageable);
    
    @Query(value = "select * from Content order by name asc",
             countQuery = "select count(*) from Content",
            nativeQuery = true)
    Page<Content> orderByAsc(Pageable pageable);
    
    @Query(value = "select * from Content order by name desc",
             countQuery = "select count(*) from Content",
            nativeQuery = true)
    Page<Content> orderByDesc(Pageable pageable);
}

