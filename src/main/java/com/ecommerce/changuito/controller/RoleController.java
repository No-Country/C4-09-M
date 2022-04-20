package com.ecommerce.changuito.controller;

import com.ecommerce.changuito.entity.Role;
import com.ecommerce.changuito.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody Role role){
        Role roleSaved = roleService.addRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleSaved);
    }

    @GetMapping
    public ResponseEntity<?> getRoles(){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getAll());
    }
}
