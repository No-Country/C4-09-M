package com.ecommerce.changuito.controller;

import java.util.*;

import com.ecommerce.changuito.dto.SaleDto;
import com.ecommerce.changuito.service.*;
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
@RequestMapping("sales")
public class SaleController {
    @Autowired
    private SaleService SaleService;

    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody SaleDto dto){
        SaleDto result = SaleService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public  ResponseEntity<?> getDetails(){
        List<SaleDto> results = SaleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        SaleService.deleteSale(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SaleDto dto){
        SaleDto result = SaleService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}