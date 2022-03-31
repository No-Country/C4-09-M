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
    private MerchandiserService merchandiserService;

    @PostMapping
    public ResponseEntity<?> addMerchandiser(@RequestBody MerchandiserDTO dto){
        MerchandiserDTO result = merchandiserService.add(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping
    public  ResponseEntity<?> getMerchandisers(){
        List<MerchandiserDTO> results = merchandiserService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

   @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        merchandiserService.deleteMerchandiser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

   @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MerchandiserDTO dto){
        MerchandiserDTO result = merchandiserService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
   }
}