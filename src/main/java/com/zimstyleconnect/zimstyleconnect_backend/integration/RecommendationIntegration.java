package com.zimstyleconnect.zimstyleconnect_backend.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class RecommendationIntegration {
    private final RestTemplate restTemplate;

    public RecommendationIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public List<String> getRecommendationsFromAI(Long userId) {
        String url = "http://localhost:5001/recommend";
        Map<String, Long> request = Map.of("userId", userId);
        ResponseEntity<List> response = restTemplate.postForEntity(url, request, List.class);
        return response.getBody();
    }
}
