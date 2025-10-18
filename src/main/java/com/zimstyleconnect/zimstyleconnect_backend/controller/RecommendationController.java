package com.zimstyleconnect.zimstyleconnect_backend.controller;

import com.zimstyleconnect.zimstyleconnect_backend.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    // 🔹 Fetch recommendations for a given user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getUserRecommendations(@PathVariable Long userId) {
        List<Map<String, Object>> recommendations = recommendationService.recommendForUser(userId);
        return ResponseEntity.ok(recommendations);
    }
}
