package com.zimstyleconnect.zimstyleconnect_backend.integration;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class AIClient {

    private final RestTemplate restTemplate;

    public AIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Generic POST request method for AI microservices.
     * @param url  Target API endpoint (Flask service URL)
     * @param body Request body as Map<String, Object>
     * @param responseType Expected response class (e.g., Map.class or List.class)
     * @return Response object (automatically cast)
     */
    public <T> T post(String url, Map<String, Object> body, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<T> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    responseType
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("AIClient Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        }
    }
}
