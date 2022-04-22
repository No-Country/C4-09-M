package com.ecommerce.changuito.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    private Content content;
    
    private Long id_image;
    
    private Double wholesaler_price;
    
    private Double retail_price;

    
    private String status;
    
    private Integer stock;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="product_cart", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_cart"))
    private Set<CartEntity> carts = new HashSet<CartEntity>();
    
    @ManyToOne
    private Category category;

   
}
