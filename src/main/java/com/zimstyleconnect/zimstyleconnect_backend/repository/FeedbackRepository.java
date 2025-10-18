package com.zimstyleconnect.zimstyleconnect_backend.repository;

import com.zimstyleconnect.zimstyleconnect_backend.entity.Feedback;
import com.zimstyleconnect.zimstyleconnect_backend.entity.Product;
import com.zimstyleconnect.zimstyleconnect_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUser(User user);
    List<Feedback> findByProduct(Product product);
    List<Feedback> findByProductProductId(Long productId);
}
