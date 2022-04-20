package com.ecommerce.changuito.repository;

import com.ecommerce.changuito.entity.Category;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    
    @Query(value = "select * from Category where name LIKE '%q%'",
            countQuery = "select count(*) from Category",
            nativeQuery=true)
    List<Category> search(@Param("q") String q);
    
    @Query(value = "select * from Category where name LIKE '%q%'",
            countQuery = "select count(*) from Category",
            nativeQuery=true)
    Page<Category> searchPage(@Param("q") String q, Pageable pageable);
    
    
    @Query(value = "select * from Category order by name asc",
            countQuery = "select count(*) from Category",
            nativeQuery = true)
    Page<Category> orderByAsc(Pageable pageable);
    
    @Query(value = "select * from Category order by name desc",
            countQuery = "select count(*) from Category",
            nativeQuery = true)
    Page<Category> orderByDesc(Pageable pageable);
}
