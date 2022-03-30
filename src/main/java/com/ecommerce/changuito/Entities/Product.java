package com.ecommerce.changuito.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String brand;
    private String name;
    private String description;
    private Double content;
    private byte [] image;
    private Double price;
    private Integer quantity;
    private String status;
    private String delete;
    private Content id_content;
    private Category id_category;

    public void setImage(byte[] image) {
        this.image=image;
    }
    
    public byte [] getImage(){
        return image;
    }
}
