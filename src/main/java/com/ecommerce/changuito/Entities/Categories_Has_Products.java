
package com.ecommerce.changuito.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name ="categories_has_products" )
@SQLDelete(sql = "UPDATE categories_has_products SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categories_Has_Products extends BaseEntity {
    
    
    private Long id_category;
    private Long  id_product;
}
