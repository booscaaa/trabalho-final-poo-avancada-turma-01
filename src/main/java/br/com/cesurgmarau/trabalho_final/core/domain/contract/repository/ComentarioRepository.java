package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    void createComentario(Comentario comentario);
    List<Comentario> readComentario();
    Comentario readComentario(int id);
    void updateComentario(int id, Comentario comentario);
    void deleteComentario(int id);
}
