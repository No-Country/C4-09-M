package com.ecommerce.changuito.controllers;

import com.ecommerce.changuito.dtos.MerchandiserDTO;
import com.ecommerce.changuito.services.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("merchandisers")
public class MerchandiserController {

    @Autowired
    private MerchandiserService service;

    @PostMapping
    public ResponseEntity<?> addMerchandiser(@RequestBody MerchandiserDTO dto){
        MerchandiserDTO result = service.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public  ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

   @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        service.deleteMerchandiser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

   @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MerchandiserDTO dto){
        MerchandiserDTO result = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
   }
}