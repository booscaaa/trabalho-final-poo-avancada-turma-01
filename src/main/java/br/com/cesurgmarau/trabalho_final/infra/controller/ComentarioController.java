package br.com.cesurgmarau.trabalho_final.infra.controller;


import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.utils.SentimentoParaNumero;
import br.com.cesurgmarau.trabalho_final.infra.exceptions.MensagemResponse;
import br.com.cesurgmarau.trabalho_final.infra.gateway.DeepSeekApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            msg.setConteudo(prompt + "Para cada resposta, crie duas linhas, uma com um título (Muito positivo, Positivo, Neutro, Negativo ou Muito negativo). Escolha apenas um desses sentimentos com base no comentário. E a outra linha com uma análise de sentimento que o comentário que te mandei transmite. Essas linhas devem ser breves e ter no máximo 5000 caracteres.");
            iaRequest.setMensagens(List.of(msg));

            DeepSeekResponse respostaIa = deepSeekApiGateway.enviarRequisicao(iaRequest);
            String sentimentoGerado = respostaIa.getChoices().get(0).getMessage().getContent();
            System.out.println(sentimentoGerado);
            comentario.setSentimento(sentimentoGerado);

            Integer nota = SentimentoParaNumero.sentimentoParaNota(comentario.getSentimento());
            comentario.setNotaSentimento(nota);

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

    @GetMapping("/comentario/{id}")
    public ResponseEntity<?> comentarioPorID(@PathVariable int id){
        if (id < 0 ) {
            throw new IllegalArgumentException("Id inválido.");
        }

        try {
            Comentario comentario = this.comentarioUseCase.comentarioPorId(id);
            if (comentario == null){
                throw new ClassNotFoundException("Comentárop não encontrado.");
            }
            return ResponseEntity.ok(comentario);
        } catch (Exception e){
            throw new RuntimeException("Erro ao listar comentário por id: " + e.getMessage());
        }
    }

    @GetMapping("/comentario")
    public ResponseEntity<?> buscaPorProduto(@RequestParam("produtoId") int id){
        try {
            List<Comentario> comentarios = this.comentarioUseCase.buscaPorProdutoId(id);
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }
    }

    @GetMapping("/comentarioU")
    public ResponseEntity<?> buscaPorUsuario(@RequestParam("usuarioId") int usuarioId){
        try {
            List<Comentario> comentarios = this.comentarioUseCase.buscaPorUsuarioId(usuarioId);
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }
    }

    @GetMapping("/sentimento")
    public ResponseEntity<?> buscaPorSentimento(@RequestParam("sentimento") String sentimento){
        int destaque = 0;
        try {
            List<Comentario> comentarios = this.comentarioUseCase.buscaPorSentimento(sentimento);
            System.out.println("sentimento: "+ sentimento);
            if (sentimento.equals("positivo")){
                destaque = destaque + 1;
                System.out.println("pontuacao: " + destaque);
            }
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos: " + e.getMessage());
        }
    }
}
