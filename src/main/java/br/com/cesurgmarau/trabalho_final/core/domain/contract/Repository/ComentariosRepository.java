package br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;
import br.com.cesurgmarau.trabalho_final.core.DTO.RelatorioComentariosDTO;
import br.com.cesurgmarau.trabalho_final.core.DTO.UsuarioRankingDTO;

import java.util.List;
import java.util.Map;

public interface ComentariosRepository {
    List<Comentarios> fetch ();
    Comentarios fetchById (int id);
    void createComentario (Comentarios comentario);
    void updateComentario (Comentarios comentario, int id);
    void deleteComentario (int id);
    List<Comentarios> buscarPorSentimento(String sentimento);
    Map<String, Double> mediaSentimentoPorProduto();
    List<UsuarioRankingDTO> rankingUsuariosMaisAtivos();
    Map<String, Long> totalComentariosPorSentimento();


}
