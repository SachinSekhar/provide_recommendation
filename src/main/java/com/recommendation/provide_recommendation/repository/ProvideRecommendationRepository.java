package com.recommendation.provide_recommendation.repository;

import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvideRecommendationRepository extends MongoRepository<CategoryMappingEntity,String> {

}
