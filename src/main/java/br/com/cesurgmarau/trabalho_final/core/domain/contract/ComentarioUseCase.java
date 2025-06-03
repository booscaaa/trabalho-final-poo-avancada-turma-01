package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioUseCase {

    public List<Comentario> listar();
    public Comentario listarPorId(int id);
    public void adicionarComentario(Comentario comentario);
    public String deletarComentario(int id);
    public String atualizarComentario(int id, Comentario comentario);
}
