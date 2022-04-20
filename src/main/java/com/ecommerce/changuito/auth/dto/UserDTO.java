package com.ecommerce.changuito.auth.dto;


import com.ecommerce.changuito.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String username;
    private String password;
    private String email;
    private List<Role> roles;
}
