package com.ecommerce.changuito.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product extends BaseEntity {
  
    private String name;

    private String image;

    private String description;

    private String code;

    private Integer precio;

    @Column(name="codigo_moneda")
    private String moneda;

    @Column(name="update_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime updateDate;

   @Column(name = "creation_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime creationDate = LocalDateTime.now();




  //  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType. REFRESH})
   // @JoinColumn(name= "cart_id")
   // private CartEntity cart;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="product_cart", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_cart"))

    private Set<CartEntity> carts = new HashSet<CartEntity>();
}
