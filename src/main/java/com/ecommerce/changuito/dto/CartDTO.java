package com.ecommerce.changuito.dto;

import com.ecommerce.changuito.entity.Product;
import com.ecommerce.changuito.utils.EnumStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data


public class CartDTO {

    private Long id;

    private EnumStatus status;

    private String ticket;   

    private LocalDateTime updateDate;

    private LocalDateTime creationDate;

    private Integer merchandiserId;

    private Integer clienteId;

    private Set<Product> products;

    }



