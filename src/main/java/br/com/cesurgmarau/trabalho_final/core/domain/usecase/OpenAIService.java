package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class OpenAIService {
    private final Dotenv dotenv = Dotenv.load();
    @Value("${openai.api.key}")
    private String apiKey;

    public String analisarSentimento(String comentario) {
        System.out.println(apiKey);
        String url = "https://api.openai.com/v1/chat/completions";

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content",
                "Analise o comentário abaixo e responda apenas com o sentimento do cliente, sem explicações. " +
                        "As opções são: Muito positivo, Positivo, Neutro, Negativo ou Muito negativo. " +
                        "Retorne somente uma dessas palavras, nada mais.\n\nComentário: " + comentario);


        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", List.of(message));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.postForObject(url, request, Map.class);

        if (response == null || !response.containsKey("choices")) {
            return "Neutro";
        }

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        Map<String, Object> firstChoice = choices.get(0);
        Map<String, String> messageResponse = (Map<String, String>) firstChoice.get("message");

        return messageResponse.get("content").trim();
    }
}
