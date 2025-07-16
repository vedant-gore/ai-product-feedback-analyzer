package com.vedant.ai_service.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private Long feedbackId;
    private Long userId;
    private Long productId;
    private String comment;
    private Integer rating;

    public FeedbackDto(Long feedbackId, Long userId, Long productId, String comment, Integer rating) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "feedbackId=" + feedbackId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
