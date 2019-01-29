package com.recommendation.provide_recommendation.service;

import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;

public interface ProvideRecommendationInterface {

    CategoryMappingEntity select(String id);
}
