package br.com.cesurgmarau.trabalho_final.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Component
public class SentimentoClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String IA_URL = "https://api.exemplo.com/sentimento"; // Substitua por uma real

    public String analisar(String texto) {
        Map<String, String> request = Map.of("text", texto);
        Map<String, Object> response = restTemplate.postForObject(IA_URL, request, Map.class);
        return response.get("sentimento").toString(); // Assuma retorno JSON: { "sentimento": "positivo" }
    }
}
