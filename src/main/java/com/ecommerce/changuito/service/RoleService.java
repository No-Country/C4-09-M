package com.ecommerce.changuito.service;

import com.ecommerce.changuito.entity.Role;

import java.util.List;

public interface RoleService {

    Role addRole(Role role);
    List<Role> getAll();
    Role findByName(String name);
}
