package com.ecommerce.changuito.controllers;

import com.ecommerce.changuito.dtos.CartDetailsDTO;
import com.ecommerce.changuito.services.CartDetailsService;

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
@RequestMapping("details")
public class CartDetailsController {
    @Autowired
    private CartDetailsService cartDetailsService;

    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody CartDetailsDTO dto){
       CartDetailsDTO result = cartDetailsService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
}
