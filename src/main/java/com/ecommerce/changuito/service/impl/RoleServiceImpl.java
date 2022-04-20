package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.entity.Role;
import com.ecommerce.changuito.repository.RoleRepository;
import com.ecommerce.changuito.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        role = roleRepository.save(role);
        return role;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        Role role = roleRepository.findByName(name);
        return role;
    }
}
