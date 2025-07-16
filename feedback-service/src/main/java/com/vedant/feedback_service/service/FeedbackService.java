package com.vedant.feedback_service.service;

import com.vedant.feedback_service.dao.FeedbackDao;
import com.vedant.feedback_service.dto.UserDto;
import com.vedant.feedback_service.feign.UserClient;
import com.vedant.feedback_service.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private UserClient userClient;

    public ResponseEntity<String> createFeedback(Feedback feedback) {
        try {
            UserDto user = userClient.getUserById(feedback.getUserId());
            if (user == null || user.getUserId() == null) {
                return new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);
            }
            feedbackDao.save(feedback);
            return new ResponseEntity<>("Feedback saved successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error Submitting Feedback.");
        }
//        feedbackDao.save(feedback);
//        return new ResponseEntity<>("Feedback saved successfully!", HttpStatus.CREATED);
    }

    public ResponseEntity<?> getFeedbackById(Long feedbackId) {
        Optional<Feedback> feedbackOpt = feedbackDao.findById(feedbackId);
        if(feedbackOpt.isPresent()){
            return ResponseEntity.ok(feedbackOpt.get()); // <-- return the actual entity
        } else {
            return new ResponseEntity<>("Feedback does not exist.", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackDao.findAll();
        if(!feedbacks.isEmpty()){
            return ResponseEntity.ok(feedbacks);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No feedbacks are present!");
        }
    }

    public ResponseEntity<List<Feedback>> getFeedbacksByUserId(Long userId){
        return ResponseEntity.ok(feedbackDao.findByUserId(userId));
    }


    public ResponseEntity<List<Feedback>> getFeedbacksByProductId(Long productId) {
        try{
            feedbackDao.findByProductId(productId);
            return ResponseEntity.ok(feedbackDao.findByProductId(productId));
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<String> deleteFeedback(Long feedbackId) {
        boolean exists = feedbackDao.existsById(feedbackId);
        if (exists) {
            feedbackDao.deleteById(feedbackId);
            return ResponseEntity.ok("Feedback deleted successfully!");
        } else {
            return new ResponseEntity<>("Feedback not found!", HttpStatus.NOT_FOUND);
        }
    }
}

//    @Autowired
//    private FeedbackClient feedbackClient;
/*
    public ResponseEntity<String> createFeedback(Feedback feedback) {
        try{
            ResponseEntity<?> response = feedbackClient.getUserById(feedback.getUserId());
            if (response.getStatusCode() != HttpStatus.FOUND) {
                return new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);
            }
            feedbackDao.save(feedback);
            return new ResponseEntity<>("Feedback saved successfully!", HttpStatus.CREATED);
        } catch(Exception e){
            return ResponseEntity.internalServerError().body("Error Submitting Feedback. Please try again later.");
        }
    }
 */

