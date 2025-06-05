package br.com.cesurgmarau.trabalho_final.infra.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OpenAiService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public String analisarSentimento(String texto) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(openAiApiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", "Analise o sentimento do seguinte texto e responda com apenas uma das opções exatas: 'muito positivo', 'positivo', 'neutro', 'negativo', ou 'muito negativo'. Não explique, apenas retorne a classificação. Texto: \"" + texto + "\"");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("messages", List.of(message));
        requestBody.put("temperature", 0.2);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_URL, request, Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> messageResult = (Map<String, Object>) choices.get(0).get("message");
            String sentimento = messageResult.get("content").toString().trim().toLowerCase();

            List<String> validSentimentos = List.of(
                    "muito positivo", "positivo", "neutro", "negativo", "muito negativo"
            );

            if (!validSentimentos.contains(sentimento)) {
                throw new RuntimeException("Sentimento não reconhecido: " + sentimento);
            }

            return sentimento;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao se comunicar com a API da OpenAI: " + e.getMessage());
        }
    }
}
