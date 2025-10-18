package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.integration.RecommendationIntegration;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class RecommendationService {
    private final RecommendationIntegration recommendationIntegration;

    public RecommendationService(RecommendationIntegration recommendationIntegration) {
        this.recommendationIntegration = recommendationIntegration;
    }

    public List<Map<String, Object>> recommendForUser(Long userId) {
        return recommendationIntegration.getRecommendations(userId);
    }
}
