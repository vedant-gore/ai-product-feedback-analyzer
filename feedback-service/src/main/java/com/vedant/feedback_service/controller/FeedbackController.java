package com.vedant.feedback_service.controller;

import com.vedant.feedback_service.model.Feedback;
import com.vedant.feedback_service.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/feedback/")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("create")
    public ResponseEntity<String> createFeedback(@RequestBody Feedback feedback){
        return feedbackService.createFeedback(feedback);
    }

    @GetMapping("/get/{feedbackId}")
    public ResponseEntity<?> getFeedbackById(@PathVariable Long feedbackId){
        return feedbackService.getFeedbackById(feedbackId);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllFeedbacks(){
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByUserId(@PathVariable Long userId){
        return feedbackService.getFeedbacksByUserId(userId);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByProductId(@PathVariable Long productId){
        return feedbackService.getFeedbacksByProductId(productId);
    }

    @DeleteMapping("/delete/{feedbackId}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long feedbackId) {
        return feedbackService.deleteFeedback(feedbackId);
    }
}
