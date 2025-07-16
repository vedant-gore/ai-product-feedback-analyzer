package com.vedant.ai_service.feign;

import com.vedant.ai_service.dto.FeedbackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "FEEDBACK-SERVICE")
public interface FeedbackClient {

    @GetMapping("/api/feedback/all")
    List<FeedbackDto> getAllFeedbacks();
    
}