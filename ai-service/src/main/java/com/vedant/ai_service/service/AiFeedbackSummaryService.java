package com.vedant.ai_service.service;

import com.vedant.ai_service.dto.FeedbackDto;
import com.vedant.ai_service.feign.FeedbackClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AiFeedbackSummaryService {

    private ChatClient chatClient;
    private FeedbackClient feedbackClient;

    public AiFeedbackSummaryService(ChatClient chatClient, FeedbackClient feedbackClient){
        this.chatClient = chatClient;
        this.feedbackClient = feedbackClient;
    }

    public ResponseEntity<String> getAiFeedbackSummary(){
        try{
            // get all feedbacks
            List<FeedbackDto> feedbacks = feedbackClient.getAllFeedbacks();

            // convert it into a single string
            String feedbacksString = feedbacks.stream()
                    .map(FeedbackDto::getComment)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining("\n"));


            String template = """
                You are an expert product feedback analyst.\s
                    Carefully read the following customer feedback data.

                    - Summarize the main points customers are making.
                    - Highlight common complaints or praises.
                    - Give 2-3 clear actionable suggestions the company can use to improve this product.

                    Here is the feedback data:
                    {feedbacks}
                """;

            // create a prompt template
            PromptTemplate promptTemplate = PromptTemplate
                    .builder()
                    .template(template)
                    .build();

            // attach the feedbacks and convert it to a String
            String promptString = promptTemplate.render(Map.of("feedbacks", feedbacksString));

            // pass this String to a prompt method
            ChatResponse chatResponse = chatClient
                    .prompt(promptString)
                    .call()
                    .chatResponse();

            String aiFeedbackSummary = chatResponse.getResult().getOutput().getText();

            return new ResponseEntity<>(aiFeedbackSummary, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.internalServerError().body("Error fetching summary from AI...");
        }
    }
}
