package br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;

import java.util.List;

public interface ComentariosUseCase {
    List<Comentarios> fetch ();
    Comentarios fetchById (int id);
    void createComentario (Comentarios comentario);
    void updateComentario (Comentarios comentario, int id);
    void deleteComentario (int id);
}
