package com.ecommerce.changuito.controller;

import java.util.List;

import com.ecommerce.changuito.dto.OrderDTO;
import com.ecommerce.changuito.service.OrderService;

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
public class OrderController {
    @Autowired
    private OrderService OrderService;

    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody OrderDTO dto){
       OrderDTO result = OrderService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public  ResponseEntity<?> getDetails(){
        List<OrderDTO> results = OrderService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        OrderService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

   @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OrderDTO dto){
        OrderDTO result = OrderService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
   }

    
}
