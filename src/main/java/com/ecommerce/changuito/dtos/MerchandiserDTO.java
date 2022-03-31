package com.ecommerce.changuito.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiserDTO {

    private Long id;

    private String name;

    private String email;

    private String description;

    private String cuit;

    private Long idCity;

    private String street;

    private String streetNumber;

    private LocalDate updateDate;

    private String creationDate;

}