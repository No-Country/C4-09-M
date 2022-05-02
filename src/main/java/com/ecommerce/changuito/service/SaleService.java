package com.ecommerce.changuito.service;

import com.ecommerce.changuito.dto.SaleDto;

import java.util.List;

public interface SaleService {
    SaleDto add(SaleDto dto);
    List<SaleDto> getAll();
    void deleteSale(Long id);
    SaleDto update(Long id, SaleDto dto);
}