package com.recommendation.provide_recommendation.service;

import com.recommendation.provide_recommendation.entity.TrendMappingEntity;

public interface ProvideTrendingInterface {
    TrendMappingEntity select(String id);
}
