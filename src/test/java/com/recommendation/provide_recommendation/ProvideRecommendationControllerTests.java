package com.recommendation.provide_recommendation;

import com.recommendation.provide_recommendation.DTO.ResponseDTO;
import com.recommendation.provide_recommendation.controller.RecommendationController;
import com.recommendation.provide_recommendation.entity.CategoryMappingEntity;
import com.recommendation.provide_recommendation.service.ProvideRecommendation;
import com.recommendation.provide_recommendation.service.ProvideTrending;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProvideRecommendationControllerTests {

    @InjectMocks
    RecommendationController recommendationController;


    @Mock
    ProvideTrending provideTrending;

    @Mock
    ProvideRecommendation provideRecommendation;

	@Test
	public void contextLoads() {
	}

	@Test
    public void testNoUserId()
    {

        Mockito.when(provideRecommendation.select(Mockito.any(String.class))).thenReturn(null);
        ResponseDTO responseDTO;
        String userId="abc";
        responseDTO=recommendationController.get(userId);
        assert(responseDTO.getStatus().equals("FAILURE"));
    }

    @Test
    public void testEmptyTrends(){

            Mockito.when(provideTrending.select(Mockito.any(String.class))).thenReturn(null);
            ResponseDTO responseDTO;
            responseDTO=recommendationController.getTrending();
            assert(responseDTO.getStatus().equals("FAILURE"));

    }
}

