package com.recommendation.provide_recommendation.repository;

import com.recommendation.provide_recommendation.entity.TrendMappingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvideTrendingRepository extends MongoRepository<TrendMappingEntity,String> {
}
