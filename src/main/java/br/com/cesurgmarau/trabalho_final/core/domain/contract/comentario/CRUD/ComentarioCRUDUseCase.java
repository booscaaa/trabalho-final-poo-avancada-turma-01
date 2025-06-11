package br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioCRUDUseCase {

    List<Comentario> fetch ();
    Comentario fetchById (int id);
    void createComentario (Comentario comentario, int produtoID);
    void updateComentario (Comentario comentario, int id);
    void deleteComentario (int id);


}
