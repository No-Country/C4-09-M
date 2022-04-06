package com.ecommerce.changuito.Entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    
    @NotBlank(message = "La marca no debe estar vacia o ser nula")
    private String brand;
    
    @NotBlank(message = "El nombre no debe estar vacio o ser nulo")
    private String name;
    
    @NotBlank(message = "La descripcion no debe estar vacia")
    private String description;
    
    private Long id_content;
    
    @NotEmpty("La imagen no debe estar vacia")
    private Long id_image;
    
    @NotEmpty(message = "El precio no debe ser nulo")
    private Double price;
    
    @NotEmpty(message = "La cantidad no debe ser nula")
    private Integer quantity;
    
    private String status;
    private Long id_category;

   
}
