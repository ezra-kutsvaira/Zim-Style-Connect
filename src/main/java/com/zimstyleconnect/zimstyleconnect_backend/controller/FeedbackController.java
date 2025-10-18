package com.zimstyleconnect.zimstyleconnect_backend.controller;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Feedback;
import com.zimstyleconnect.zimstyleconnect_backend.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // POST: Submit feedback and trigger AI analysis
    @PostMapping("/submit")
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Map<String, Object> payload) {
        Long userId = Long.valueOf(payload.get("userId").toString());
        String reviewText = payload.get("reviewText").toString();

        Feedback saved = feedbackService.submitFeedback(userId, reviewText);
        return ResponseEntity.ok(saved);
    }

    // 🧩 GET: Retrieve all feedbacks (for admin or analysis)
    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }
}
