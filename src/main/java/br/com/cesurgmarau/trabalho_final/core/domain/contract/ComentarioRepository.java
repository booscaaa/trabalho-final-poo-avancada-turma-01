package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioRepository {
    public void adicionarComentario (Comentario comentario);
    public ComentarioDTO listarComentarioPorId(int id);
    public List<ComentarioDTO> listarComentario();
    public List<ComentarioDTO> listarComentarioPorProduto(int produto_id);
    public List<ComentarioDTO> listarUsuarioComComentario(int usuario_id);
    public List<ComentarioDTO> listarComentarioPorSentimento(int sentimento_id);
}
