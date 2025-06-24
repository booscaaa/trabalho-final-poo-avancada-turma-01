package br.com.cesurgmarau.trabalho_final.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SentimentoAIClientImpl implements SentimentoAIClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${sentimento.api.url}")
    private String apiUrl;

    @Value("${sentimento.api.key}")
    private String apiKey;

    @Override
    public String analisarSentimento(String texto) {
        // Montar a requisição para a API de IA
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        String requestBody = "{\"text\":\"" + texto + "\"}";

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<ApiResponse> response = restTemplate.postForEntity(apiUrl, request, ApiResponse.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                // Suponha que a API retorna um campo 'sentiment' com o sentimento
                return response.getBody().getSentiment();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Caso falhe, retorna neutro
        return "Neutro";
    }

    // Classe interna para mapear a resposta JSON da API
    static class ApiResponse {
        private String sentiment;

        public String getSentiment() {
            return sentiment;
        }

        public void setSentiment(String sentiment) {
            this.sentiment = sentiment;
        }
    }
}
