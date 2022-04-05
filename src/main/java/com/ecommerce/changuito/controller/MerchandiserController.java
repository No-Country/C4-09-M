package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.service.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/merchandisers")
public class MerchandiserController {

    @Autowired
    private MerchandiserService service;

    @PostMapping
    public ResponseEntity<?> addMerchandiser(@Valid @RequestBody MerchandiserDto dto) {
        MerchandiserDto result = service.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }


    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody MerchandiserDto dto){
        MerchandiserDto result = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
