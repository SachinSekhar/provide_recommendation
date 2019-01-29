package com.recommendation.provide_recommendation.controller;


import com.recommendation.provide_recommendation.DTO.ResponseDTO;
import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import com.recommendation.provide_recommendation.service.ProvideRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RecommendationController {

    @Autowired
    ProvideRecommendation provideRecommendation;

    @GetMapping(path = "/recommendation/get/{id}")
    public ResponseDTO<HashMap<String,Double>> get(@PathVariable String id) {
        CategoryMappingEntity categoryMappingEntity=provideRecommendation.select(id);
        ResponseDTO<HashMap<String,Double>> responseDTO=new ResponseDTO<>();
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("SUCCESS");

        if(categoryMappingEntity==null)
        {
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("USER NOT FOUND");
            responseDTO.setResponse(null);
            return responseDTO;
        }


        responseDTO.setResponse(categoryMappingEntity.getCategories());
        return responseDTO;
    }
}
