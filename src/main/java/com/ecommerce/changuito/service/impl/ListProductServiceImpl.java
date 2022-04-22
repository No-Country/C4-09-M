package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.entity.ListProduct;
import com.ecommerce.changuito.entity.Product;
import com.ecommerce.changuito.error.ErrorService;
import com.ecommerce.changuito.repository.ListProductRepository;
import com.ecommerce.changuito.repository.ProductRepository;
import com.ecommerce.changuito.service.ListProductService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListProductServiceImpl implements ListProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ListProductRepository listProductRepository;

    @Override
    public void addProducts(Long id_product, Long id_listProduct) throws ErrorService {
        Optional<ListProduct> optional = findById(id_listProduct);
        if (optional.isPresent()) {
            ListProduct listProduct = optional.get();
            listProduct.getListProduct().add(productRepository.getById(id_product));
        } else {
            Optional<Product> answer = productRepository.findById(id_product);
            if (answer.isPresent()) {
                Product product = answer.get();
                ListProduct listProduct = new ListProduct();
                ArrayList<Product> productsArray = new ArrayList<>();
                productsArray.add(product);
                listProduct.setListProduct(productsArray);
            } else {
                throw new ErrorService("No existe el producto");
            }
        }

    }

    @Override
    public Optional<ListProduct> findById(Long id_listProduct) {
        return listProductRepository.findById(id_listProduct);
    }

    @Override
    public void removePorduct(Long id_product, Long id_listProduct) throws ErrorService {
        Optional<ListProduct> optional = findById(id_listProduct);
        if (optional.isPresent()) {
            ListProduct listProduct = optional.get();
            if (!listProduct.getListProduct().isEmpty()) {
                listProduct.getListProduct().remove(productRepository.getById(id_product));
            } else {
                throw new ErrorService("No tiene mas productos para eliminar");
            }
        } else {
            throw new ErrorService("No existe la lista de productos");
        }
    }

    @Override
    public boolean wholesalePremise(Long id_product, Long id_listProduct) throws ErrorService {

        Optional<ListProduct> optional = findById(id_listProduct);
        Optional<Product> answer = productRepository.findById(id_product);
        if (optional.isPresent()) {
            ListProduct listProduct = optional.get();
            if (answer.isPresent()) {
                Product product = answer.get();
                return product.getAllowed_price()==verificationPremise(id_product, id_listProduct);
            }else{
                throw new ErrorService("El producto no existe");
            }
        }else{
            throw new ErrorService("La lista de productos seleccionados no existe");
        }

       
    }

    @Override
    public Integer verificationPremise(Long id_product, Long id_listProduct) throws ErrorService {
        Integer count = 0;
        Optional<ListProduct> optional = findById(id_listProduct);
        Optional<Product> answer = productRepository.findById(id_product);
        if (optional.isPresent()) {
            ListProduct listProduct = optional.get();
            if (answer.isPresent()) {
                Product product = answer.get();
                for (int i = 0; i < listProduct.getListProduct().size(); i++) {
                    if (listProduct.getListProduct().get(i).equals(product)) {
                        count++;
                    }
                }
                return count;
            }else{
                throw new ErrorService("El producto no existe");
            }
        }else{
            throw new ErrorService("La lista de productos seleccionados no existe");
        }
    }

}
