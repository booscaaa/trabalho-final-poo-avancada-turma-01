package br.com.cesurgmarau.trabalho_final.infra.controller;


import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.infra.exceptions.MensagemResponse;
import br.com.cesurgmarau.trabalho_final.infra.gateway.DeepSeekApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComentarioController {

    @Autowired

    private ComentarioUseCase comentarioUseCase;
    private DeepSeekApiGateway deepSeekApiGateway;

    public ComentarioController(@Qualifier("comentarioUseCaseImpl") ComentarioUseCase comentarioUseCase, @Qualifier("deepSeekGateway") DeepSeekApiGateway deepSeekApiGateway){
        this.comentarioUseCase = comentarioUseCase;
        this.deepSeekApiGateway = deepSeekApiGateway;
    }

    @PostMapping("/comentario")
    public ResponseEntity<MensagemResponse> comentar(@RequestBody Comentario comentario) {
        if (comentario.getComentario().isBlank() || comentario.getComentario() == null) {
            throw new IllegalArgumentException("Preencha todos os dados.");
        }

        try {
            String prompt = comentario.getComentario();
            DeepSeekRequest iaRequest = new DeepSeekRequest();
            iaRequest.setModelo("deepseek/deepseek-r1-0528:free");

            DeepSeekRequest.Message msg = new DeepSeekRequest.Message();
            msg.setRegra("user");
            msg.setConteudo(prompt);
            iaRequest.setMensagens(List.of(msg));

            DeepSeekResponse respostaIa = deepSeekApiGateway.enviarRequisicao(iaRequest);
            System.out.println(respostaIa);
            String sentimentoGerado = respostaIa.getChoices().get(0).getMessage().getContent();
            System.out.println(sentimentoGerado);
            comentario.setSentimento(sentimentoGerado);

            comentarioUseCase.adicionarComentario(comentario);
            return ResponseEntity.ok(new MensagemResponse("Comentário adicionado!"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar comentário: " + e.getMessage());
        }
    }

    @GetMapping("/comentarios")
    public ResponseEntity<?> listaComentarios() {
        try {
            List<Comentario> comentarios = comentarioUseCase.listarComentarios();
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar comentários: " + e.getMessage());
        }
    }
}
