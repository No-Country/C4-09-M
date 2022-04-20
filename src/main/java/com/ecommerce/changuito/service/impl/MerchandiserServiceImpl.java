package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.auth.mapper.UserMapper;
import com.ecommerce.changuito.auth.service.UserDetailsCustomService;
import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.entity.ClientEntity;
import com.ecommerce.changuito.entity.MerchandiserEntity;
import com.ecommerce.changuito.entity.Role;
import com.ecommerce.changuito.entity.UserEntity;
import com.ecommerce.changuito.mapper.MerchandiserMapper;
import com.ecommerce.changuito.repository.MerchandiserRepository;
import com.ecommerce.changuito.service.MerchandiserService;
import com.ecommerce.changuito.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MerchandiserServiceImpl implements MerchandiserService {
    @Autowired
    private MerchandiserRepository merchandiserRepository;
    @Autowired
    private MerchandiserMapper merchandiserMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private RoleService roleService;


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public MerchandiserDto add(MerchandiserDto dto) throws Exception{
        MerchandiserEntity entity = merchandiserMapper.merchandiserDto2Entity(dto);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_MERCHANDISER"));
        entity.setUser(userMapper.userDto2UserEntity(dto.getUser()));
        entity.getUser().setPassword(bCryptPasswordEncoder.encode(entity.getUser().getPassword()));
        entity.getUser().setRoles(roles);
        UserEntity userEntity = userDetailsCustomService.findByUsername(entity.getUser().getUsername());
        if (userEntity != null){
            throw new Exception("Username alredy exist!");
        }
        MerchandiserEntity entitySaved = merchandiserRepository.save(entity);
        return merchandiserMapper.merchandiserEntity2Dto(entitySaved);
    }

    @Override
    @Transactional
    public List<MerchandiserDto> getAll() {
        List<MerchandiserDto> dtos =
                merchandiserMapper.merchandiserEntityList2Dtos(merchandiserRepository.findAll());
        return dtos;
    }

    @Override
    @Transactional
    public MerchandiserDto update(Long id, MerchandiserDto dto) {
        Optional<MerchandiserEntity> entity = merchandiserRepository.findById(id);
        if (entity.isPresent()) {
            MerchandiserEntity entitySaved = entity.get();
            entitySaved = merchandiserMapper.merchandiserDto2Entity(dto);
            entitySaved = merchandiserRepository.save(entitySaved);
            MerchandiserDto result = merchandiserMapper.merchandiserEntity2Dto(entitySaved);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Optional<MerchandiserEntity> entity = merchandiserRepository.findById(id);
        if (entity.isPresent()){
            merchandiserRepository.deleteById(id);
        }else{
            throw new RuntimeException("Invalid id");
        }
    }
}