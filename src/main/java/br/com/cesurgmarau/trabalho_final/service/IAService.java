package br.com.cesurgmarau.trabalho_final.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.io.IOException;

@Service
public class IAService {


    @Value("${huggingface.api.token}")
    private String huggingFaceApiToken;

    private static final String API_URL = "https://api-inference.huggingface.co/models/cardiffnlp/twitter-roberta-base-sentiment";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    public IAService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public String classificarSentimento(String texto) throws Exception {

        String payload = "{\"inputs\": \"" + texto.replace("\"", "'") + "\"}";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(huggingFaceApiToken);

        HttpEntity<String> entity = new HttpEntity<>(payload, headers);


        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            JsonNode root = objectMapper.readTree(response.getBody());

            JsonNode labels = root.get(0);
            if (labels != null && labels.isArray()) {
                for (JsonNode node : labels) {
                    String label = node.get("label").asText().toLowerCase();
                    double score = node.get("score").asDouble();


                    if (label.equals("positive")) {
                        if (score > 0.85) return "muito positivo";
                        else return "positivo";
                    } else if (label.equals("neutral")) {
                        return "neutro";
                    } else if (label.equals("negative")) {
                        if (score > 0.85) return "muito negativo";
                        else return "negativo";
                    }
                }
            }
            return "neutro";
        } else {
            throw new RuntimeException("Erro na chamada da API HuggingFace: " + response.getStatusCode());
        }
    }
}
