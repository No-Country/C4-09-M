
package com.ecommerce.changuito.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "list_product")
@SQLDelete(sql = "UPDATE list_product SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListProduct extends BaseEntity{
    
    @OneToMany
    private ArrayList<Product> listProduct= new ArrayList<>();
    
   
    
    
}
