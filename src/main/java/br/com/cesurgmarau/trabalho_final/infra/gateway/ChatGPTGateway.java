package br.com.cesurgmarau.trabalho_final.infra.gateway;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.AnaliseOutput.AnaliseDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Component
public class ChatGPTGateway {

    @Value("${openrouter.api.url}")
    private String API_URL;

    @Value("${openrouter.api.key}")
    private String API_KEY;

    public AnaliseDTO analisarComentario(Comentario comentarioAnalise) {

        var comentario = comentarioAnalise.getComentario();

        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            String prompt = "Analise o seguinte comentário sobre um produto e retorne separadamente em duas respostas: "
                    + "1) Um resumo da análise de sentimentos "
                    + "2) A palavra que representa o sentimento (muito positivo, positivo, neutro, negativo ou muito negativo) **Retornar -> sentimento: palavra que representa o sentimento (sem pontuação e sem espaços EX: se sentimento = muito negativo, retorne: muitonegativo).\n\n"
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

            String[] partes = conteudo.split("(?i)sentimento\\s*[:\\-]\\s*");
            String analise = partes[0].trim();
            String sentimento = partes.length > 1 ? partes[1].trim() : "desconhecido";

            AnaliseDTO dto = new AnaliseDTO();
            dto.setAnalise(analise);
            dto.setSentimento(sentimento);

            comentarioAnalise.setAnalise(analise);
            comentarioAnalise.setSentimento(sentimento);

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
