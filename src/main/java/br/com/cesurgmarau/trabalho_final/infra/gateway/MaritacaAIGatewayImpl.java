package br.com.cesurgmarau.trabalho_final.infra.gateway;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.MaritacaAIGateway;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.MaritacaAIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class MaritacaAIGatewayImpl implements MaritacaAIGateway {

    @Value("${MARITACA_API_KEY}")
    private String apiKey;

    @Override
    public String commentAssess(String comment) {
        try {
            String requestBody = String.format("""
                {
                    "model": "sabia-3",
                    "messages": [
                        {
                            "role": "system",
                            "content": "Você é um avaliador de sentimentos em comentários. Analise o comentário e retorne APENAS UMA das seguintes opções: MUITO BOM, BOM, MÉDIO, RUIM, MUITO RUIM"
                        },
                        {
                            "role": "user",
                            "content": "%s"
                        }
                    ],
                    "max_tokens": 8000
                }
                """, comment);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://chat.maritaca.ai/api/chat/completions"))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();

            MaritacaAIResponse maritaAIResponse = mapper.readValue(response.body(), MaritacaAIResponse.class);

            return maritaAIResponse.choices.getFirst().message.content.strip();
        } catch (Exception e) {
            throw new RuntimeException("Error assessing comment: " + e.getMessage());
        }
    }
}
