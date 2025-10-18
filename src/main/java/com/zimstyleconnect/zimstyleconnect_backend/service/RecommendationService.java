package com.zimstyleconnect.zimstyleconnect_backend.service;
import com.zimstyleconnect.zimstyleconnect_backend.integration.RecommendationIntegration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    private final RecommendationIntegration recommendationIntegration;

    public RecommendationService(RecommendationIntegration recommendationIntegration) {
        this.recommendationIntegration = recommendationIntegration;
    }

    public List<String> getRecommendations(Long userId) {
        return recommendationIntegration.getRecommendationsFromAI(userId);
    }

}
