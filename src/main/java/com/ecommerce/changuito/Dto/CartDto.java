package com.ecommerce.changuito.dto;

import com.ecommerce.changuito.entity.Product;
import com.ecommerce.changuito.utils.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data

@AllArgsConstructor
public class CartDto {

    private Long id;

    private EnumStatus status;

    private String ticket;

    private LocalDateTime updateDate;

    private LocalDateTime creationDate;

    private Integer merchandiserId;

    private Integer clientId;

    private Set<Product> products;

    public CartDto() {
    }
}
