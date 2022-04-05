package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.entity.MerchandiserEntity;
import com.ecommerce.changuito.mapper.MerchandiserMapper;
import com.ecommerce.changuito.repository.MerchandiserRepository;
import com.ecommerce.changuito.service.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MerchandiserServiceImpl implements MerchandiserService {
    @Autowired
    private MerchandiserRepository merchandiserRepository;
    @Autowired
    private MerchandiserMapper merchandiserMapper;

    @Override
    public MerchandiserDto add(MerchandiserDto dto) {
        MerchandiserEntity entity = merchandiserMapper.merchandiserDto2Entity(dto);
        MerchandiserEntity entitySaved = merchandiserRepository.save(entity);
        return merchandiserMapper.merchandiserEntity2Dto(entitySaved);
    }

    @Override
    @Transactional
    public List<MerchandiserDto> getAll() {
        List<MerchandiserDto> dtos =
                merchandiserMapper.merchandiserEntityList2Dtos(merchandiserRepository.findAll());
        return dtos;
    }

    @Override
    @Transactional
    public MerchandiserDto update(Long id, MerchandiserDto dto) {
        Optional<MerchandiserEntity> entity = merchandiserRepository.findById(id);
        if (entity.isPresent()) {
            MerchandiserEntity entitySaved = entity.get();
            entitySaved = merchandiserMapper.merchandiserDto2Entity(dto);
            entitySaved = merchandiserRepository.save(entitySaved);
            MerchandiserDto result = merchandiserMapper.merchandiserEntity2Dto(entitySaved);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Optional<MerchandiserEntity> entity = merchandiserRepository.findById(id);
        if (entity.isPresent()){
            merchandiserRepository.deleteById(id);
        }else{
            throw new RuntimeException("Invalid id");
        }
    }
}