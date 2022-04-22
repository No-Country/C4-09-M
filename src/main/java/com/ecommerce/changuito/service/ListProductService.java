
package com.ecommerce.changuito.service;

import com.ecommerce.changuito.entity.ListProduct;
import com.ecommerce.changuito.error.ErrorService;
import java.util.Optional;


public interface ListProductService {
    
     public void addProducts(Long id_product, Long id_listProduct) throws ErrorService;

     public Optional<ListProduct> findById(Long id_listProduct);
     
     public void removePorduct(Long id_product, Long id_listProduct) throws ErrorService;
     
     public boolean wholesalePremise(Long id_product, Long id_listProduct)throws ErrorService;
     
     public Integer verificationPremise(Long id_product, Long id_listProduct) throws ErrorService;
}
