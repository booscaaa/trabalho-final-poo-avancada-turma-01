package br.com.cesurgmarau.trabalho_final.core.UseCase.impl;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.FeelingRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.FeelingUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Feeling;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.*;


@Service
public class FeelingAnalyzerUseCaseImpl implements FeelingUseCase {
    @Value("${huggingface.api.key}")
    private String apiToken;

    @Value("${huggingface.api.url}")
    private String apiUrl;

    private final FeelingRepository feelingRepository;

    public FeelingAnalyzerUseCaseImpl(FeelingRepository feelingRepository) {
        this.feelingRepository = feelingRepository;
    }


    public int analyzeSentiment(String text) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + apiToken);


        Map<String, String> body = new HashMap<>();
        body.put("inputs", text);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<List> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    List.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                List<List<Map<String, Object>>> result = response.getBody();
                if (result != null && !result.isEmpty()) {
                    Map<String, Object> prediction = result.get(0).stream()
                            .max(Comparator.comparingDouble(o -> (Double) o.get("score")))
                            .orElse(null);

                    if (prediction != null) {
                        String label = (String) prediction.get("label");
                        String feelingName = mapLabelToFeeling(label);
                        System.out.println("Resposta da API: " + response.getBody());
                        System.out.println("Label: " + label);
                        System.out.println("Sentimento mapeado: " + feelingName);
                        return this.feelingRepository.findByNameIgnoreCase(feelingName)
                                .map(Feeling::getId)
                                .orElseThrow(() -> new IllegalStateException("Sentimento '" + feelingName + "' não encontrado no banco de dados."));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public Optional<Feeling> findByNameIgnoreCase(String name) {
        return feelingRepository.findByNameIgnoreCase(name);
    }


    private String mapLabelToFeeling(String label) {
        switch (label) {
            case "1 star":
                return "Very Negative";
            case "2 stars":
                return "Negative";
            case "3 stars":
                return "Neutral";
            case "4 stars":
                return "Positive";
            case "5 stars":
                return "Very Positive";
            default:
                return "Neutral";
        }
    }
}

