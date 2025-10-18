package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Feedback;
import com.zimstyleconnect.zimstyleconnect_backend.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DashboardService {

    private final FeedbackRepository feedbackRepository;
    private final RecommendationService recommendationService;

    public DashboardService(FeedbackRepository feedbackRepository,
                            RecommendationService recommendationService) {
        this.feedbackRepository = feedbackRepository;
        this.recommendationService = recommendationService;
    }

    public Map<String, Object> getUserDashboard(Long userId) {
        Map<String, Object> dashboardData = new HashMap<>();

        // 1️⃣  Fetch feedback history
        List<Feedback> feedbackList = feedbackRepository.findAll()
                .stream()
                .filter(f -> f.getUser().getUserId().equals(userId))
                .toList();

        // 2️⃣  Compute simple sentiment summary
        long positiveCount = feedbackList.stream()
                .filter(f -> "positive".equalsIgnoreCase(f.getSentimentLabel()))
                .count();
        long negativeCount = feedbackList.stream()
                .filter(f -> "negative".equalsIgnoreCase(f.getSentimentLabel()))
                .count();
        long neutralCount = feedbackList.size() - positiveCount - negativeCount;

        Map<String, Object> sentimentSummary = Map.of(
                "totalFeedback", feedbackList.size(),
                "positive", positiveCount,
                "negative", negativeCount,
                "neutral", neutralCount
        );

        // 3️⃣  Get AI-based product recommendations
        List<Map<String, Object>> recommendations = recommendationService.recommendForUser(userId);

        // 4️⃣  Combine into one response
        dashboardData.put("userId", userId);
        dashboardData.put("feedbackHistory", feedbackList);
        dashboardData.put("sentimentSummary", sentimentSummary);
        dashboardData.put("recommendations", recommendations);
        dashboardData.put("generatedAt", new Date());

        return dashboardData;
    }
}
