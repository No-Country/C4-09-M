package com.ecommerce.changuito.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="merchandiser")
@SQLDelete(sql = "UPDATE merchandiser SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiserEntity extends BaseEntity{


    private String name;

    //TODO: agregar relación con usuario a la entidad Merchandiser

    private String email;

    private String description;

    @Column(length = 11)
    private String cuit;

    //TODO: agregar relación con la city
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name="update_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

}
