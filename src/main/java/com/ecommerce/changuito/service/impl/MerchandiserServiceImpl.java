package com.ecommerce.changuito.service.impl;

import com.ecommerce.changuito.dto.MerchandiserDto;
import com.ecommerce.changuito.entity.MerchandiserEntity;
import com.ecommerce.changuito.mapper.MerchandiserMapper;
import com.ecommerce.changuito.repository.MerchandiserRepository;
import com.ecommerce.changuito.service.MerchandiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
