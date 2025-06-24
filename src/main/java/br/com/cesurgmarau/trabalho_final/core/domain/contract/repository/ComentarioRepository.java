package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    void createComentario(Comentario comentario);
    List<Comentario> readComentario();
    Comentario readComentario(Integer id);
    void updateComentario(Integer id, Comentario comentario);
    void deleteComentario(Integer id);
    List<Comentario> readComentarioByNullSentimento();
    List<Comentario> findByProdutoId(Integer produtoId);
    List<Comentario> findByUsuarioId(Integer usuarioId);
}
