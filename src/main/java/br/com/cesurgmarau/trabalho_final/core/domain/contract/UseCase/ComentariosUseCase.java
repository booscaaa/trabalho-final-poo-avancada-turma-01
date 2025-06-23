package br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;
import br.com.cesurgmarau.trabalho_final.core.DTO.RelatorioComentariosDTO;
import br.com.cesurgmarau.trabalho_final.core.DTO.UsuarioRankingDTO;

import java.util.List;
import java.util.Map;

public interface ComentariosUseCase {
    List<Comentarios> fetch ();
    Comentarios fetchById (int id);
    void createComentario (Comentarios comentario);
    void updateComentario (Comentarios comentario, int id);
    void deleteComentario (int id);
    RelatorioComentariosDTO gerarRelatorio();
    List<Comentarios> buscarPorSentimento(String sentimento);



}
