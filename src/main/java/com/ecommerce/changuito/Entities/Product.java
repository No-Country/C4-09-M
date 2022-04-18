package com.ecommerce.changuito.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    
    private String brand;
    
    private String name;
    
    private String description;
    
    private Long id_content;
    
    private Long id_image;
    
    private Double wholesaler_price;
    
    private Double retail_price;
    
    private Integer quantity;
    
    private String status;
    
    private Long id_category;

   
}
