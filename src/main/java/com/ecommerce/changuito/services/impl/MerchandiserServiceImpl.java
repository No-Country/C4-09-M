package com.ecommerce.changuito.services.impl;

import com.ecommerce.changuito.dtos.MerchandiserDTO;
import com.ecommerce.changuito.entities.MerchandiserEntity;
import com.ecommerce.changuito.mapper.MerchandiserMapper;
import com.ecommerce.changuito.repositories.MerchandiserRepository;
import com.ecommerce.changuito.services.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MerchandiserServiceImpl implements MerchandiserService {

    @Autowired
    private MerchandiserMapper merchandiserMapper;
    @Autowired
    private MerchandiserRepository merchandiserRepository;

    @Override
    @Transactional
    public MerchandiserDTO add(MerchandiserDTO dto) {
        MerchandiserEntity entity = merchandiserMapper.merchandiserDto2Entity(dto);
        entity = merchandiserRepository.save(entity);
        MerchandiserDTO result = merchandiserMapper.merchandiserEntity2Dto(entity);
        return result;
    }

    @Override
    @Transactional
    public List<MerchandiserDTO> getAll() {
        List<MerchandiserDTO> results;
        List<MerchandiserEntity> entities = merchandiserRepository.findAll();
        results = merchandiserMapper.merchandiserEntityList2DtosList(entities);
        return results;
    }

    @Override
    @Transactional
    public void deleteMerchandiser(Long id) {
        merchandiserRepository.deleteById(id);
    }

    @Override
    @Transactional
    public MerchandiserDTO update(Long id, MerchandiserDTO dto) {
        MerchandiserEntity entity = merchandiserRepository.getById(id);
        if (entity != null){
            entity = merchandiserMapper.merchandiserDto2Entity(dto);
            entity = merchandiserRepository.save(entity);
            MerchandiserDTO result = merchandiserMapper.merchandiserEntity2Dto(entity);
            return  result;
        }else{
            return null;
        }


    }
}