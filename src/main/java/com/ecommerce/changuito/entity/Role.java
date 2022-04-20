package com.ecommerce.changuito.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
@SQLDelete(sql = "UPDATE roles SET deleted = false WHERE id = ?")
@Where(clause = "deleted = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

    @NotEmpty(message = "Role name can't be empty")
    private String name;


    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<UserEntity> users;

}
