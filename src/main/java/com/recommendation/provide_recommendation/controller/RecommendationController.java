package com.recommendation.provide_recommendation.controller;


import com.recommendation.provide_recommendation.DTO.ResponseDTO;
import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import com.recommendation.provide_recommendation.entity.TrendMappingEntity;
import com.recommendation.provide_recommendation.service.ProvideRecommendation;
import com.recommendation.provide_recommendation.service.ProvideTrending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RecommendationController {

    @Autowired
    ProvideRecommendation provideRecommendation;

    @Autowired
    ProvideTrending provideTrending;


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


    @GetMapping(path = "/recommendation/getForNewUser")
    public ResponseDTO<HashMap<String,Double>> getTrending() {
        TrendMappingEntity trendMappingEntity=provideTrending.select("trending");
        ResponseDTO<HashMap<String ,Double>> responseDTO=new ResponseDTO<>();
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("SUCCESS");

        if(trendMappingEntity==null)
        {
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("TRENDS NOT AVAILABLE AT THE MOMENT");
            responseDTO.setResponse(null);
            return responseDTO;
        }
        responseDTO.setResponse((trendMappingEntity.getCategories()));
        return responseDTO;
    }

    }


