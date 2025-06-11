package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioRepository {
    public void adicionarComentario (Comentario comentario);
    public ComentarioDTO listarComentarioPorId(int id);
    public List<ComentarioDTO> listarComentario();
    public List<ComentarioDTO> listarComentarioPorProduto(int produtoId);
    public List<ComentarioDTO> listarComentarioPorUsuario(int usuarioId);
    public List<ComentarioDTO> listarComentarioPorSentimento(int sentimentoId);
}
