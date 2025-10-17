package com.zimstyleconnect.zimstyleconnect_backend.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "recommendation_log")
public class RecommendationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recId;

    @Column(columnDefinition = "TEXT")
    private String recommendedIds;

    private String modelVersion;
    private Double responseScore;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public RecommendationLog() {}

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getRecommendedIds() {
        return recommendedIds;
    }

    public void setRecommendedIds(String recommendedIds) {
        this.recommendedIds = recommendedIds;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public Double getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(Double responseScore) {
        this.responseScore = responseScore;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
