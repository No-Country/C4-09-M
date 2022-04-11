package com.ecommerce.changuito.auth.service;

import com.ecommerce.changuito.auth.dto.UserDTO;
import com.ecommerce.changuito.auth.repository.UserRepository;
import com.ecommerce.changuito.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity==null){
            throw new UsernameNotFoundException("Usarname or password not valid");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
        //Collections.emptyList() es para reemplazar los roles.
    }

    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userEntity.setEmail(userDTO.getEmail());
        userEntity = this.userRepository.save(userEntity);
        if (userEntity != null){
            //emailService.sendWelcomeEmail(userEntity.getEmail());
        }
        return userEntity != null;

    }

    public UserEntity findByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);
        return userEntity;
    }
}
