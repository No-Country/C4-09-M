package com.ecommerce.changuito.dtos;

 import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

 import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String image;
    private String code;
    private String description;
    private Integer precio;
    private LocalDate updateDate;
    private LocalDate creationDate;
    private String moneda;

}