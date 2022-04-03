package com.ecommerce.changuito.dtos;

import java.time.LocalDateTime;

import com.ecommerce.changuito.utils.EnumPayment;

import lombok.Data;

@Data

public class CartDetailsDTO {
    
    private Long id;

    private String productId;

    private Integer quantity;

    private Integer total;

    private EnumPayment payment;

    private LocalDateTime updateDate;

    private LocalDateTime creationDate;




}
