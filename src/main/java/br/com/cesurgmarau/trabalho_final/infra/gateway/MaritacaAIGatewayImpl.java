package br.com.cesurgmarau.trabalho_final.infra.gateway;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.MaritacaAIGateway;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.maritacaai.MaritacaAIResponse;
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
                            "content": "Você é um avaliador de sentimentos em comentários. Analise o comentário e retorne APENAS UMA das seguintes opções: MUITO BOM, BOM, MÉDIO, RUIM, MUITO RUIM, INDEFINIDO"
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

    @Override
    public String commentScore(String comment) {
        try {
            String requestBody = String.format("""
                    {
                      "max_tokens": 8000,
                      "messages": [
                        {
                          "role": "system",
                          "content": "Você é um analista de texto especializado em qualidade de comunicação escrita. Sua tarefa é avaliar a *qualidade* de um comentário de usuário, independentemente do seu sentimento (se é positivo, negativo, neutro, etc.). O foco da avaliação é estritamente a *estrutura*, *conteúdo* e *correção linguística* do texto. Considere os seguintes critérios para sua avaliação: 1.  Riqueza de Detalhes e Profundidade:  -   O comentário fornece informações específicas ou é muito genérico? -   Ele aprofunda o ponto que está sendo feito ou é superficial? -   Apresenta exemplos, justificativas, ou contextualização relevante? -   Adiciona valor ou insight significativo à discussão? 2.  Clareza e Compreensibilidade: -   A mensagem é fácil de entender à primeira leitura? -   Existe alguma ambiguidade ou confusão na formulação?  -   A estrutura das frases e parágrafos é lógica e bem organizada? -   O vocabulário utilizado é adequado e preciso para o contexto? -   A ideia principal é comunicada de forma direta e eficiente?3.  Ortografia, Gramática e Formatação: -   Existem erros de ortografia? (Ex: 'peneu' em vez de 'pneu')(Ex: falta de vírgula, ponto final, uso inadequado de exclamação/interrogação)-   Existem erros gramaticais? (Ex: concordância verbal/nominal, regência, crase, colocação pronominal) -   O texto está bem formatado (uso de parágrafos, capitalização correta, espaçamento)? -  O uso de gírias, abreviações ou emojis é apropriado e não prejudica a clareza? Instruções para a Pontuação (0-100): - 0-20 (Muito Baixa Qualidade): Incoerente, incompreensível, muitos erros (ortográficos, gramaticais, pontuação), completamente desorganizado, sem detalhes relevantes ou valor. - 21-40 (Baixa Qualidade): Difícil de entender, muitos erros, pouco detalhe, estrutura confusa, prejudica a comunicação da mensagem.- 41-60 (Qualidade Média): Compreensível, mas com erros notáveis ou falta de detalhes. Pode ser genérico ou requerer esforço para entender completamente.- 61-80 (Boa Qualidade): Claro, poucos erros (menores e que não prejudicam a compreensão), fornece detalhes úteis e tem uma estrutura razoável. - 81-100 (Excelente Qualidade): Excepcio,nalmente claro, detalhado, bem estruturado, rico em informações relevantes, praticamente sem erros ortográficos, gramaticais ou de pontuação. Comunicação impecável e de alto valor. Formato de Saída:(um inteiro de 0 a 100). Não adicione nenhum texto, explicação ou pontuação adicional."
                        },
                        {
                          "role": "user",
                          "content": "%s"
                        }
                      ],
                      "model": "sabia-3"
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
