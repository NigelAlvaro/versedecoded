package com.example.versedecoded;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import java.util.List;
import java.util.Map;

@Service
public class OpenAIService {
    private static final String MODEL = "gpt-3.5-turbo";
    private static final double TEMPERATURE = 0.7;
    
    @Value("${openai.api.key}")
    private String apiKey;
    
    @Value("${openai.api.url}")
    private String apiUrl;
    
    private final RestTemplate restTemplate;

    public OpenAIService(RestTemplate restTemplate) {  // Constructor injection
        this.restTemplate = restTemplate;
    }

    public String getResponse(String prompt) {
        HttpHeaders headers = createHeaders();
        Map<String, Object> requestBody = createRequestBody(prompt);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        try {
            OpenAIResponse response = restTemplate.postForObject(apiUrl, request, OpenAIResponse.class);
            return extractResponseContent(response);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get response from OpenAI", e);
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        return headers;
    }

    private Map<String, Object> createRequestBody(String prompt) {
        return Map.of(
            "model", MODEL,
            "messages", List.of(Map.of("role", "user", "content", prompt)),
            "temperature", TEMPERATURE
        );
    }

    private String extractResponseContent(OpenAIResponse response) {
        if (response != null && !response.getChoices().isEmpty()) {
            return response.getChoices().get(0).getMessage().getContent();
        }
        throw new RuntimeException("Invalid response from OpenAI API");
    }
}