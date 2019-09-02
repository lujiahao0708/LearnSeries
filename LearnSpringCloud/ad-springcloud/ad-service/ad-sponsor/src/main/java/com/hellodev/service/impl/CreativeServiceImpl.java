package com.hellodev.service.impl;

import com.hellodev.dao.CreativeRepository;
import com.hellodev.entity.Creative;
import com.hellodev.service.ICreativeService;
import com.hellodev.vo.CreativeRequest;
import com.hellodev.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lujiahao
 * @date 2019-09-02
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
