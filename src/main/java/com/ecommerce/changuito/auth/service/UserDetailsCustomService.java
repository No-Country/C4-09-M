package com.ecommerce.changuito.auth.service;

import com.ecommerce.changuito.auth.dto.UserDTO;
import com.ecommerce.changuito.auth.mapper.UserMapper;
import com.ecommerce.changuito.auth.repository.UserRepository;
import com.ecommerce.changuito.entity.Role;
import com.ecommerce.changuito.entity.UserEntity;
import com.ecommerce.changuito.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        userEntity.getRoles().forEach( role -> roles.add(new SimpleGrantedAuthority(role.getName())));
        if(userEntity==null){
            throw new UsernameNotFoundException("Usarname or password not valid");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
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

    public UserDTO createAdmin(UserEntity user){
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_ADMIN"));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserDTO result = userMapper.userEntity2UserDto(userRepository.save(user));
        return result;
    }
}
