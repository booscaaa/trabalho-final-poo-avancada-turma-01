package br.com.cesurgmarau.trabalho_final.infra.gateway;

import br.com.cesurgmarau.trabalho_final.core.dto.AnaliseOutput.AnaliseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Component
public class ChatGPTGateway {

    private static final String API_URL = "";
    private static final String API_KEY = "Bearer ";

    public AnaliseDTO analisarComentario(String comentario) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            String prompt = "Analise o seguinte comentário sobre um produto e retorne: "
                    + "1) Um resumo da análise de sentimentos "
                    + "2) A palavra que representa o sentimento (positivo, negativo ou neutro):\n\n"
                    + comentario;

            Map<String, Object> message = Map.of(
                    "role", "user",
                    "content", prompt
            );

            Map<String, Object> body = Map.of(
                    "model", "gpt-4o-mini",
                    "messages", List.of(message),
                    "n", 1
            );

            String requestBody = mapper.writeValueAsString(body);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Authorization", API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode root = mapper.readTree(response.body());
            String conteudo = root.get("choices").get(0).get("message").get("content").asText();

            // Aqui você pode usar um parser ou regex para separar a análise e o sentimento.
            // Exemplo simples:
            String[] partes = conteudo.split("(?i)sentimento\\s*[:\\-]\\s*");
            String analise = partes[0].trim();
            String sentimento = partes.length > 1 ? partes[1].trim() : "desconhecido";

            AnaliseDTO dto = new AnaliseDTO();
            dto.setAnalise(analise);
            dto.setSentimento(sentimento);

            return dto;

        } catch (Exception e) {
            e.printStackTrace();
            AnaliseDTO erro = new AnaliseDTO();
            erro.setAnalise("Erro ao processar: " + e.getMessage());
            erro.setSentimento("erro");
            return erro;
        }
    }

}
