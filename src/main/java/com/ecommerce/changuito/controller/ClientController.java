package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.dto.ClientDto;
import com.ecommerce.changuito.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ClientDto dto){
        try {
            ClientDto result = service.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }


    }

    @GetMapping
    public ResponseEntity<?> getAll(){

            List<ClientDto> dtos = service.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody ClientDto dto){
        try{
            ClientDto result = service.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
