package com.ecommerce.changuito.controllers;

import com.ecommerce.changuito.dtos.CartDTO;
import com.ecommerce.changuito.entities.CartEntity;
import com.ecommerce.changuito.services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("carts")
public class CartController {
    
    @Autowired
    private CartService cartService;

        @PostMapping
        public ResponseEntity<?> addCart(@RequestBody CartDTO dto){
           CartDTO result = cartService.add(dto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
}

