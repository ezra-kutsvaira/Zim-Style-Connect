package com.zimstyleconnect.zimstyleconnect_backend.integration;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class RecommendationIntegration {

    private final AIClient aiClient;

    public RecommendationIntegration(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public List<Map<String, Object>> getRecommendations(Long userId) {
        String url = "http://localhost:5000/api/recommendations";
        return aiClient.post(url, Map.of("userId", userId), List.class);
    }
}
