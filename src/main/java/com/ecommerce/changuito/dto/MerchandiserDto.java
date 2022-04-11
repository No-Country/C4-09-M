package com.ecommerce.changuito.dto;

import com.ecommerce.changuito.auth.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiserDto {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String description;
    private String cuit;
    private String street;
    private String streetNumber;
    private String updateDate;
    private String creationDate;
    private UserDTO user;

}
