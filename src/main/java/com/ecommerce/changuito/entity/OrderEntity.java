package com.ecommerce.changuito.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.ecommerce.changuito.utils.EnumPayment;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order")
@SQLDelete(sql = "UPDATE order SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data


public class OrderEntity extends BaseEntity {
    @Column(name = "id_cart", nullable = false, updatable=true)
    private Integer cartId;

    @Column(name = "total_price", nullable = false, updatable=true)
    private Integer total;

    @Column(name = "payment", nullable = false, updatable=true)
    @Enumerated(value = EnumType.STRING)
    private EnumPayment enumPayment;

    @Column(name="update_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime updateDate;

   @Column(name = "creation_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDateTime creationDate = LocalDateTime.now();


    
}
