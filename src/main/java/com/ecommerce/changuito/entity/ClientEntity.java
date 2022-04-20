package com.ecommerce.changuito.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "client")
@SQLDelete(sql = "UPDATE client SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity extends BaseEntity{

    @NotBlank(message = "Name is mandatory")
    private String firstname;

    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    private String dni;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String country;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity user;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDate created;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updated;

}
