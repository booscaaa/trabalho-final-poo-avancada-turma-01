package br.com.cesurgmarau.trabalho_final.infra.service.ia;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.AnaliseSentimentoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnaliseSentimentoOpenAIService implements AnaliseSentimentoService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String analisarSentimento(String texto) {
        String prompt = "Classifique o sentimento do seguinte comentário em uma única palavra dentre: Muito positivo, Positivo, Neutro, Negativo ou Muito negativo. Apenas responda com uma dessas palavras:\n\n" + texto;

        String endpoint = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> request = new HashMap<>();
        request.put("model", "gpt-3.5-turbo");

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", prompt);

        request.put("messages", new Object[]{message});
        request.put("temperature", 0.2);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, Map.class);

        try {
            Map<String, Object> choice = ((java.util.List<Map<String, Object>>) response.getBody().get("choices")).get(0);
            Map<String, String> messageResponse = (Map<String, String>) choice.get("message");
            return messageResponse.get("content").trim();
        } catch (Exception e) {
            return "Neutro";
        }
    }
}