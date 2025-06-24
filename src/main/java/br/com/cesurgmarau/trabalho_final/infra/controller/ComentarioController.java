package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.SentimentAnalyzer;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.Ia.ComentarioComSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.util.SentimentoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.cesurgmarau.trabalho_final.core.dto.ia.ComentarioSentimentoDTO;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    private final ComentarioUseCase comentarioUseCase;
    private final SentimentAnalyzer sentimentAnalyzer;

    public ComentarioController(ComentarioUseCase comentarioUseCase, SentimentAnalyzer sentimentAnalyzer) {
        this.comentarioUseCase = comentarioUseCase;
        this.sentimentAnalyzer = sentimentAnalyzer;
    }

    @PostMapping
    public ResponseEntity<ComentarioComSentimentoDTO> insert(@RequestBody Comentario comentario) {
        String resultadoSentimento = sentimentAnalyzer.analisarComentario(comentario.getDescricao());
        int sentimentoId = SentimentoMapper.mapSentimentoToId(resultadoSentimento);
        comentario.setSentimento_id(sentimentoId);

        comentarioUseCase.insert(comentario);

        ComentarioComSentimentoDTO dto = new ComentarioComSentimentoDTO();
        dto.setId(comentario.getId());
        dto.setDescricao(comentario.getDescricao());
        dto.setProduto_id(comentario.getProduto_id());
        dto.setUsuario_id(comentario.getUsuario_id());
        dto.setSentimento_id(sentimentoId);
        dto.setSentimento_texto(resultadoSentimento);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Comentario comentario) {
        comentarioUseCase.update(id, comentario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        comentarioUseCase.delete(id);
    }

    @GetMapping("/{id}")
    public Comentario getById(@PathVariable int id) {
        return comentarioUseCase.getById(id);
    }

    @GetMapping
    public List<Comentario> fetch() {
        return comentarioUseCase.fetch();
    }

    @GetMapping("/produto/{produto_id}")
    public List<Comentario> getByProdutoId(@PathVariable int produto_id) {
        return comentarioUseCase.getByProdutoId(produto_id);
    }

    @GetMapping("/usuario/{usuario_id}")
    public List<Comentario> getByUsuarioId(@PathVariable int usuario_id) {
        return comentarioUseCase.getByUsuarioId(usuario_id);
    }

    @GetMapping("/sentimento/{sentimento_id}")
    public List<Comentario> getBySentimento(@PathVariable int sentimento_id) {
        return comentarioUseCase.getBySentimento(sentimento_id);
    }

    @PostMapping("/analisar")
    public Map<String, String> analisarSentimento(@RequestBody ComentarioSentimentoDTO dto) {
        String resultado = sentimentAnalyzer.analisarComentario(dto.getComentario());
        return Map.of("sentimento", resultado);
    }
}
