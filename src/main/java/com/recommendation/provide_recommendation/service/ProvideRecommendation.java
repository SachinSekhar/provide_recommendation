package com.recommendation.provide_recommendation.service;

import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import com.recommendation.provide_recommendation.entity.TrendMappingEntity;
import com.recommendation.provide_recommendation.repository.ProvideRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProvideRecommendation implements ProvideRecommendationInterface{

    @Autowired
    ProvideRecommendationRepository provideRecommendationRepository;


    @Override
    public CategoryMappingEntity select(String id) {
        return provideRecommendationRepository.findOne(id);
    }


}
