package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.integration.SentimentIntegration;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class SentimentService {
    private final SentimentIntegration sentimentIntegration;

    public SentimentService(SentimentIntegration sentimentIntegration) {
        this.sentimentIntegration = sentimentIntegration;
    }

    public Map<String, Object> analyzeFeedbackText(String text) {
        return sentimentIntegration.analyzeSentiment(text);
    }
}
