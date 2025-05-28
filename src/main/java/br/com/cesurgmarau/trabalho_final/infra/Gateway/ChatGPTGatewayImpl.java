package br.com.cesurgmarau.trabalho_final.infra.Gateway;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ChatGPTGateway;
import br.com.cesurgmarau.trabalho_final.core.dto.OpenIAResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ChatGPTGatewayImpl implements ChatGPTGateway {
    @Override
    public String identificarSentimento(String comentario) throws IOException {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("OPENAI_API_KEY");
        String endpoint = "https://api.openai.com/v1/chat/completions";

        String jsonInput = String.format("""
            {
              "model": "gpt-4o-mini",
              "messages": [
                {
                  "role": "system",
                  "content": "Você é um analisador de sentimentos. Responda APENAS com uma das seguintes palavras (e NADA mais): MuitoPositivo, Positivo, Neutro, Negativo, MuitoNegativo. Não inclua explicações, nem formate como JSON. Apenas retorne uma dessas palavras conforme o sentimento do comentário."
                },
                {
                  "role": "user",
                  "content": "%s"
                }
              ]
            }
            """, comentario);

        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        OpenIAResponse openAIResponse = mapper.readValue(response.toString(), OpenIAResponse.class);

        String content = openAIResponse.getChoices().get(0).getMessage().getContent();

        return content;
    }
}
