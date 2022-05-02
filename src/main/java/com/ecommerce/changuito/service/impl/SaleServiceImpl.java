package com.ecommerce.changuito.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.ecommerce.changuito.dto.SaleDto;
import javax.transaction.Transactional;
import com.ecommerce.changuito.entity.SaleEntity;
import com.ecommerce.changuito.mapper.SaleMapper;
import com.ecommerce.changuito.repository.SaleRepository;
import com.ecommerce.changuito.service.SaleService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper SaleMapper;

    @Autowired
    private SaleRepository SaleRepository;

    @Override
    @Transactional
    public SaleDto add(SaleDto dto) {
        SaleEntity entity = SaleMapper.SaleDto2Entity(dto);
        entity.setUpdateDate(LocalDateTime.now());
        entity.setCreationDate(LocalDateTime.now());
        entity = SaleRepository.save(entity);
        SaleDto result = SaleMapper.SaleEntity2Dto(entity);
        return result;
    }

    @Override
    @Transactional
    public List<SaleDto> getAll() {
        List<SaleDto> results;
        List<SaleEntity> entities = SaleRepository.findAll();
        results = SaleMapper.SaleEntityList2DtosList(entities);
        return results;
    }

    @Override
    @Transactional
    public void deleteSale(Long id) {
        SaleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SaleDto update(Long id, SaleDto dto) {
        SaleEntity entity = SaleRepository.getById(id);
        if (entity != null){
            entity = SaleMapper.SaleDto2Entity(dto);
            entity = SaleRepository.save(entity);
            SaleDto result = SaleMapper.SaleEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }
    }



}