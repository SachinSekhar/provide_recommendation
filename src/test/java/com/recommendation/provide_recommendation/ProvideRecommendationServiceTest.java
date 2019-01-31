package com.recommendation.provide_recommendation;


import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import com.recommendation.provide_recommendation.repository.ProvideRecommendationRepository;
import com.recommendation.provide_recommendation.service.ProvideRecommendation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ProvideRecommendationServiceTest {

    @InjectMocks
    ProvideRecommendation provideRecommendation;

    @Mock
    ProvideRecommendationRepository provideRecommendationRepository;


    @Test
    public void testBadUserId(){
        Mockito.when(provideRecommendationRepository.findOne(Mockito.any(String.class))).thenReturn(null);

        String userId="abc";
        CategoryMappingEntity categoryMappingEntity;
        categoryMappingEntity=provideRecommendation.select(userId);
        assertNull(categoryMappingEntity);

    }
}
