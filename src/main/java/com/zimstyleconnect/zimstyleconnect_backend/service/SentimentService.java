package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.integration.SentimentIntegration;
import org.springframework.stereotype.Service;

@Service
public class SentimentService {
    private final SentimentIntegration sentimentIntegration;


    public SentimentService(SentimentIntegration sentimentIntegration) {
        this.sentimentIntegration = sentimentIntegration;
    }

    //sentiment analysis in the SentimentIntegration Application
    public String analyzeSentiment(String text){
        return sentimentIntegration.getSentimentFromAI(text);
    }
}
