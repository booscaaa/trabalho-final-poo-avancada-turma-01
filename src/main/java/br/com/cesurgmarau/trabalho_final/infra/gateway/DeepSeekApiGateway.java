package br.com.cesurgmarau.trabalho_final.infra.gateway;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@Service("deepSeekGateway")
public class DeepSeekApiGateway {
    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";
    @Value("${openrouter.api.key}")
    private String API_KEY;

    public DeepSeekResponse enviarRequisicao(DeepSeekRequest deepSeekRequest) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String requestBody = mapper.writeValueAsString(deepSeekRequest);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL))
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .header("HTTP-Referer", "http://localhost:8080") // opcional
                .header("X-Title", "trabalho-final") // opcional
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> resp = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(resp.body(), DeepSeekResponse.class);
    }
}
