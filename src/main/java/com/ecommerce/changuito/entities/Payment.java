package com.ecommerce.changuito.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Payment{
    
     public enum PaymentEnum{
        MERCADO_PAGO(1), TARJETA_DE_DEBITO(2), TARJETA_DE_CREDITO(3), EFECTIVO(4); 
        private final Integer value;

        private PaymentEnum(Integer value){
            this.value = value;
        }

        public static PaymentEnum parse(Integer id) {
            PaymentEnum status = null;
            for(PaymentEnum item : PaymentEnum.values()) {
                if(item.getValue().equals(id)){
                    status = item;
                    break;
                }
            }
            return status;
        }

        private Integer getValue() {
            return value;
        }


    }


}
