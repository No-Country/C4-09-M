
package com.ecommerce.changuito.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "content")
@SQLDelete(sql = "UPDATE content SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content extends BaseEntity {
 
    @NotBlank(message = "El nombre de la unidad no debe estar vacio o ser nulo")
    private String name;
    
}
