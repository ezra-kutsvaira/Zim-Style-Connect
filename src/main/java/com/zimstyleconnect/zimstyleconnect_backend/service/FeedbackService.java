package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Feedback;
import com.zimstyleconnect.zimstyleconnect_backend.entity.User;
import com.zimstyleconnect.zimstyleconnect_backend.integration.SentimentIntegration;
import com.zimstyleconnect.zimstyleconnect_backend.repository.FeedbackRepository;
import com.zimstyleconnect.zimstyleconnect_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final SentimentIntegration sentimentIntegration;
    private final UserRepository userRepository;

    public FeedbackService(FeedbackRepository feedbackRepository,
                           SentimentIntegration sentimentIntegration,
                           UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.sentimentIntegration = sentimentIntegration;
        this.userRepository = userRepository;
    }

    public Feedback submitFeedback(Long userId, String reviewText) {
        //  Fetch the user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        //  Send feedback text to Flask AI
        Map<String, Object> aiResponse = sentimentIntegration.analyzeSentiment(reviewText);

        // Extract sentiment info
        String label = (String) aiResponse.getOrDefault("sentiment", "neutral");
        double score = (Double) aiResponse.getOrDefault("score", 0.0);

        //  Save in database
        Feedback feedback = new Feedback();
        feedback.setReviewText(reviewText);
        feedback.setSentimentLabel(label);
        feedback.setSentimentScore(score);
        feedback.setUser(user);

        return feedbackRepository.save(feedback);
    }

    public java.util.List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
}
