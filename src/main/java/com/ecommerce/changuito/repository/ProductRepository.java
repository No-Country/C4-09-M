package com.ecommerce.changuito.repository;

import com.ecommerce.changuito.entity.Product;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
   @Query(value = "select * from Product",
            countQuery = "select count(*) from Product",
           nativeQuery = true) 
   Page<Product> findAllPage(Pageable pageable);
   
   @Query(value = "select * from Product where brand LIKE '%q%' or name LIKE '%q%'",countQuery = "select count(*) from Product", nativeQuery = true )
   List<Product> search(@Param("q") String q);
   
   @Query(value = "select * from Product where brand LIKE '%q%' or name LIKE '%q%'", countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> searchPage(@Param("q") String q, Pageable pageable);

   @Query(value = "select * from Product order by brand asc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> brandOrderByAsc(Pageable pageable);
   
   @Query(value = "select * from Product order by brand desc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> brandOrderByDesc(Pageable pageable);
   
   @Query(value = "select * from Product order by name asc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> nameOrderByAsc(Pageable pageable);
   
   @Query(value = "select * from Product order by name desc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> nameOrderByDesc(Pageable pageable);
   
   @Query(value = "select * from Product order by wholesaler_price asc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> wholesaler_priceOrderByAsc(Pageable pageable);
   
   @Query(value = "select * from Product order by wholesaler_price desc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> wholesaler_priceOrderByDesc(Pageable pageable);
   
   @Query(value = "select * from Product order by retail_price asc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> retail_priceOrderByAsc(Pageable pageable);
   
   @Query(value = "select * from Product order by retail_price desc",countQuery = "select count(*) from Product", nativeQuery = true)
   Page<Product> retail_priceOrderByDesc(Pageable pageable);
   
   @Query(value = "select * from Product where id_category = id", countQuery = "select count (* Product)", nativeQuery = true)
   Page<Product> productForCategory(@Param("id") Long id, Pageable pageable);
}
