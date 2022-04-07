package com.ecommerce.changuito.controllers;

import java.util.List;

import com.ecommerce.changuito.dtos.CartDetailsDTO;
import com.ecommerce.changuito.services.CartDetailsService;

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

    @GetMapping
    public  ResponseEntity<?> getDetails(){
        List<CartDetailsDTO> results = cartDetailsService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        cartDetailsService.deleteCartDetails(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

   @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CartDetailsDTO dto){
        CartDetailsDTO result = cartDetailsService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
   }

    
}
