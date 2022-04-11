package com.ecommerce.changuito.entities;

    import javax.persistence.Entity;
    import javax.persistence.Table;
    
    import org.hibernate.annotations.SQLDelete;
    import org.hibernate.annotations.Where;
    
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Entity
    @Table(name="Cliente")
    @SQLDelete(sql = "UPDATE product SET deleted = true WHERE id=?")
    @Where(clause = "deleted=false")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    
    public class ClienteEntity extends BaseEntity {
      
        private String name;
    
        private String image;
        
    }
    
