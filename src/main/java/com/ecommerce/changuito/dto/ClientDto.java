package com.ecommerce.changuito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String dni;
    private String birthday;
    private String country;
    private String created;
    private String updated;



}
