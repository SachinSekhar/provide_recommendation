package com.recommendation.provide_recommendation.controller;


import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import com.recommendation.provide_recommendation.service.ProvideRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    @Autowired
    ProvideRecommendation provideRecommendation;

    @GetMapping(path = "/recommendation/{id}")
    public CategoryMappingEntity get(@PathVariable String id) {
        CategoryMappingEntity categoryMappingEntity=provideRecommendation.select(id);
        return categoryMappingEntity;

    }
}
