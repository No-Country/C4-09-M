package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.service.CartService;
import com.ecommerce.changuito.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("carts")
public class CartController {
    
    @Autowired
    private CartService service;

        @PostMapping
        public ResponseEntity<?> addCart(@RequestBody CartDto dto){
           com.ecommerce.changuito.dto.CartDto result = service.add(dto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        @GetMapping
        public  ResponseEntity<?> getAll(){
            return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
        }
    
       @DeleteMapping("{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id){
            service.deleteCart(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
    
       @PutMapping("{id}")
        public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CartDto dto){
            CartDto result = service.update(id, dto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
       }
}

