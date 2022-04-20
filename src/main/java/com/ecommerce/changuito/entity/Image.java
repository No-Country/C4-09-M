
package com.ecommerce.changuito.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Image")
@SQLDelete(sql = "UPDATE image SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseEntity{
    
    private String nombre;
    private String mime;
    
    @Lob @Basic(fetch = FetchType.EAGER)
    private byte [] contenido;
}
