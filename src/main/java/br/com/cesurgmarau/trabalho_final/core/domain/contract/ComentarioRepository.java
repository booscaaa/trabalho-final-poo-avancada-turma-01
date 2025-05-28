package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    public void adicionarComentario (Comentario comentario);
    public Comentario listarComentarioPorId(int id);
    public List<Comentario> listarComentario();
}
