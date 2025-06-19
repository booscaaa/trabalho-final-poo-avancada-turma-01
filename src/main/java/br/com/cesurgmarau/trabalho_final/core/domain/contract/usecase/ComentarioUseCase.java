package br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioUseCase {
    void createComentario(Comentario comentario);
    List<Comentario> readComentario();
    Comentario readComentario(Integer id);
    void updateComentario(Integer id, Comentario comentario);
    void deleteComentario(Integer id);
}
