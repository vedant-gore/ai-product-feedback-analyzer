package com.vedant.feedback_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vedant.feedback_service.model.Feedback;

import java.util.List;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Long> {


    List<Feedback> findByUserId(Long userId);

    List<Feedback> findByProductId(Long productId);
}
