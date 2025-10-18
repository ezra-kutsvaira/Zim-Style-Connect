package com.zimstyleconnect.zimstyleconnect_backend.integration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class SentimentIntegration {

    private final RestTemplate restTemplate;

    public SentimentIntegration(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //make use of Flask endpoint
    public String getSentimentFromAI(String text) {
        String url = "http://localhost:5050/analyze"; //Flask API endpoint
        Map<String, String> request = Map.of("text", text);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        return (String) response.getBody().get("sentiment");
    }
}
