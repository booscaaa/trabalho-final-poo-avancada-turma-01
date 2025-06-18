package br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    void adicionarComentario(Comentario comentario);
    List<Comentario> listarComentarios();
    Comentario comentarioPorId(int id);
    void atualizarComentario(int id, Comentario comentario);
    void deletarComentario(int id);
}
