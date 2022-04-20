package com.ecommerce.changuito.dto;

import java.time.LocalDateTime;

import com.ecommerce.changuito.utils.EnumPayment;

import lombok.Data;

@Data

public class OrderDTO {
    
    private Long id;

    private Integer cartId;

    private Integer total;

    private EnumPayment payment;

    private LocalDateTime updateDate;

    private LocalDateTime creationDate;

}
