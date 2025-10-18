package com.zimstyleconnect.zimstyleconnect_backend.service;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Feedback;
import com.zimstyleconnect.zimstyleconnect_backend.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedbacks(){
        return feedbackRepository.findAll();
    }

    public List<Feedback> getFeedbacksByProduct(Long productId) {
        return feedbackRepository.findByProductProductId(productId);
    }

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

}
