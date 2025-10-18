package com.zimstyleconnect.zimstyleconnect_backend.integration;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class SentimentIntegration {

    private final AIClient aiClient;

    public SentimentIntegration(AIClient aiClient) {
        this.aiClient = aiClient;
    }

    public Map<String, Object> analyzeSentiment(String text) {
        String url = "http://localhost:5000/api/sentiment";
        return aiClient.post(url, Map.of("text", text), Map.class);
    }
}
