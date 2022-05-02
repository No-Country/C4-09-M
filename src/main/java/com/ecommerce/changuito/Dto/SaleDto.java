package com.ecommerce.changuito.dto;

import com.ecommerce.changuito.utils.EnumPayment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {

    private Long id;

    private Integer cartId;

    private Integer total;

    private EnumPayment payment;

    private LocalDateTime updateDate;

    private LocalDateTime creationDate;
}