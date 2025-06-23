package br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
     Comentario insert (Comentario comentario);
     void update (int id, Comentario comentario);
     void delete (int id);
    List<Comentario> buscarTodosOsComentarios();
    Comentario buscarComentarioPorId(int id);
    List<Comentario> buscarProdutoPorId(int livroId);
    List<Comentario> buscarUsuarioPorId(int usuarioId);

    List<Comentario> buscarTodos();
}

