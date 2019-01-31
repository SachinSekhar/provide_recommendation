package com.recommendation.provide_recommendation.service;

import com.recommendation.provide_recommendation.entity.TrendMappingEntity;
import com.recommendation.provide_recommendation.repository.ProvideTrendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProvideTrending implements ProvideTrendingInterface{

    @Autowired
    ProvideTrendingRepository provideTrendingRepository;

    @Override
    public TrendMappingEntity select(String id)
    {
        return provideTrendingRepository.findOne("trending");
    }
}
