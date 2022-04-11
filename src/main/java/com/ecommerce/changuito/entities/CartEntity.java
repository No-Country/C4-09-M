package com.ecommerce.changuito.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import com.ecommerce.changuito.utils.EnumStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@SQLDelete(sql = "UPDATE cart SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartEntity extends BaseEntity {
   @Column(name = "status", nullable = false, updatable = true)
   @Enumerated(value = EnumType.STRING)
   private EnumStatus enumStatus;

   private String ticket;

   @Column(name = "id_cliente", nullable = false, updatable=true)
   private Integer clienteId;

   @Column(name = "id_merchandiser", nullable = false, updatable=true)
   private Integer merchandiserId;

   @Column(name="update_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime updateDate;

   @Column(name = "creation_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime creationDate = LocalDateTime.now();

   @JsonIgnore
   @ManyToMany(mappedBy = "carts")
   private Set<Product> products = new HashSet<Product>();

   //@JsonIgnore
   //@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  // private List<Product> products = new ArrayList<>();

   //@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
   //@JoinColumn(name = "id_merchandiser")
   //private MerchandiserEntity merchandiser;

 //  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
  // @JoinColumn(name = "id_cliente", nullable = false, updatable=true)
  // private ClienteEntity cliente;

}
