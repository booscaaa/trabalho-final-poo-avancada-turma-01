package br.com.cesurgmarau.trabalho_final.infra.IA;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.SentimentAnalyzer;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class OpenAISentimentAnalyzer implements SentimentAnalyzer {

    private static final String API_KEY = ("OPENAI_API_KEY");;

    @Override
    public String analisarComentario(String comentario) {
        try {
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String prompt = "Classifique o sentimento do seguinte comentário de produto em uma das seguintes opções: " +
                    "'Muito negativo', 'Negativo', 'Neutro', 'Positivo' ou 'Muito positivo'. " +
                    "Responda apenas com uma dessas palavras, sem explicações. Comentário: " + comentario;

            String body = "{\n" +
                    "  \"model\": \"gpt-3.5-turbo\",\n" +
                    "  \"messages\": [\n" +
                    "    {\"role\": \"user\", \"content\": \"" + prompt.replace("\"", "\\\"") + "\"}\n" +
                    "  ],\n" +
                    "  \"temperature\": 0\n" +
                    "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = body.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

            String json = response.toString();
            int index = json.indexOf("\"content\":\"");
            if (index != -1) {
                int start = index + 11;
                int end = json.indexOf("\"", start);
                String resposta = json.substring(start, end);
                return resposta.replaceAll("[\\n\\r\"]", "").trim();
            }

            return "Erro: resposta inesperada";

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro na chamada OpenAI";
        }
    }
}
