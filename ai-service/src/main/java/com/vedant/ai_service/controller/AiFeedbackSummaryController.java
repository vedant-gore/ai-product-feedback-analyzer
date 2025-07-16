package com.vedant.ai_service.controller;

import com.vedant.ai_service.service.AiFeedbackSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiFeedbackSummaryController {

    @Autowired
    private AiFeedbackSummaryService aiFeedbackSummaryService;

    @GetMapping("feedbackSummary")
    public ResponseEntity<String> getAiFeedbackSummary(){
        return aiFeedbackSummaryService.getAiFeedbackSummary();
    }
}
