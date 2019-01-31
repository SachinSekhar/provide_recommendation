package com.recommendation.provide_recommendation;

import com.recommendation.provide_recommendation.entity.TrendMappingEntity;
import com.recommendation.provide_recommendation.repository.ProvideTrendingRepository;
import com.recommendation.provide_recommendation.service.ProvideTrending;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ProvideTrendingServiceTests {

    @InjectMocks
    ProvideTrending provideTrending;

    @Mock
    ProvideTrendingRepository provideTrendingRepository;

    @Test
    public void testNoTrends(){
        Mockito.when(provideTrendingRepository.findOne(Mockito.any(String.class))).thenReturn(null);

        String userId="abc";
        TrendMappingEntity trendMappingEntity;
        trendMappingEntity=provideTrending.select(userId);
        assertNull(trendMappingEntity);

    }


}
