package com.zimstyleconnect.zimstyleconnect_backend.repository;

import com.zimstyleconnect.zimstyleconnect_backend.entity.RecommendationLog;
import com.zimstyleconnect.zimstyleconnect_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationLogRepository extends JpaRepository<RecommendationLog, Long> {
    List<RecommendationLog> findByUser(User user);
}
