package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.io.IOException;
import java.util.List;

public interface ComentarioUseCase {
    public void adicionarComentario (Comentario comentario) throws IOException;
    public Comentario listarComentarioPorId(int id);
    public List<Comentario> listarComentario();
}
