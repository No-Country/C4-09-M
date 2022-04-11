package com.ecommerce.changuito.utils;

public enum EnumPayment {
    MERCADO_PAGO, TARJETA_DE_DEBITO, TARJETA_DE_CREDITO, EFECTIVO;
    
}

/*To implement in the entity 
@Column(name="payment", nullable = false, updatable = true)
@Enumerated(value = EnumType.STRING)
private EnumPayment enumPayment; */
