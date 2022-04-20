package com.ecommerce.changuito.auth.controller;

import com.ecommerce.changuito.auth.dto.AuthenticationRequest;
import com.ecommerce.changuito.auth.dto.AuthenticationResponse;
import com.ecommerce.changuito.auth.dto.UserDTO;
import com.ecommerce.changuito.auth.service.JwtUtils;
import com.ecommerce.changuito.auth.service.UserDetailsCustomService;
import com.ecommerce.changuito.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtTokenUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDTO userDTO) throws Exception{
        this.userDetailsCustomService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest authRequest) throws Exception{
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @PostMapping("/signup/admin")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserEntity userEntity) throws Exception{
        this.userDetailsCustomService.createAdmin(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }
}
