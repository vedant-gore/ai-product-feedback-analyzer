package com.vedant.ai_service.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder){

        ChatOptions feedbackChatOptions = ChatOptions
                .builder()
                .temperature(0.3)  //sets creativity, less gives factual
                .frequencyPenalty(0.5) //Penalizes using the same words again and again in the output. -2.0 to 2.0 (default 0)
                .presencePenalty(0.3) //Encourages talking about new topics instead of sticking to the same ideas repeatedly. -2.0 to 2.0 (default 0)
                .maxTokens(200)    // sets the total number of words in the output summary
                .build();

        // set the systems behaviour
        return chatClientBuilder
                .defaultOptions(feedbackChatOptions)
                .defaultSystem("You are an expert feedback analyst. "
                        + "You carefully review customer feedback, extract key insights, and provide honest, data-driven suggestions to help improve the company's products. "
                        + "Always focus on what customers truly think, summarizing their sentiments clearly and objectively.")
                .build();
    }
}
