package br.com.cesurgmarau.trabalho_final.infra.gateway;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.gateway.AIGateway;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ChatGPTGatewayImpl implements AIGateway {

    private final String apiKey;
    private final HttpClient httpClient;

    public ChatGPTGatewayImpl() {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("OPENAI_API_KEY");
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public String enviarMensagem(String mensagem) {
        try {
            String requestBody = """
                {
                  "model": "gpt-3.5-turbo",
                  "messages": [
                    {
                      "role": "user",
                      "content": "%s"
                    }
                  ]
                }
                """.formatted(mensagem);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao consultar a API: " + e.getMessage();
        }
    }

    @Override
    public int classificarComentario(String texto) {
        String prompt = """
            Avalie o seguinte comentário de 0 a 4, sendo:
            0 = Muito negativo
            1 = Negativo
            2 = Neutro
            3 = Positivo
            4 = Muito positivo
            Retorne apenas o número.

            Comentário: "%s"
            """.formatted(texto);

        String resposta = enviarMensagem(prompt);

        try {
            String numero = resposta.replaceAll("[^0-4]", "").trim();

            if(numero.isEmpty()) {
                return 2;
            }

            return Integer.parseInt(numero);
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }
}
