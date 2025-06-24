package br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    void cadastrarComentario(Comentario comentario);
    List<Comentario> listarComentario();
    Comentario getId(Long id);
    void atualizarComentario(Comentario comentario, Long id);
    void deletaComentario(Long id);
}