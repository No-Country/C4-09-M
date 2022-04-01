package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.exception.ErrorHandler;
import com.ecommerce.changuito.service.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/merchandisers")
public class MerchandiserController {

    @Autowired
    private MerchandiserService service;

    @PostMapping
    public ResponseEntity<?> addMerchandiser(@Valid @RequestBody MerchandiserDto dto)
            throws MethodArgumentNotValidException {
        MerchandiserDto result = service.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);


    }

}
