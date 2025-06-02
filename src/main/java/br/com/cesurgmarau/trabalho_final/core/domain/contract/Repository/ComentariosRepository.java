package br.com.cesurgmarau.trabalho_final.Core.domain.contract.Repository;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;

import java.util.List;

public interface ComentariosRepository {
    List<Comentarios> fetch ();
    Comentarios fetchById (int id);
    void createComentario (Comentarios comentario);
    void updateComentario (Comentarios comentario, int id);
    void deleteComentario (int id);
}
