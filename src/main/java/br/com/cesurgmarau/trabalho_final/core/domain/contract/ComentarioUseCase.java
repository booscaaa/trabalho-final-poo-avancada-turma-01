package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorUsuarioDTO;

import java.io.IOException;
import java.util.List;

public interface ComentarioUseCase {
    public void adicionarComentario (Comentario comentario) throws IOException;
    public ComentarioDTO listarComentarioPorId(int id);
    public List<ComentarioDTO> listarComentario();
    public ComentarioPorProdutoDTO listarProdutoComComentarios(int produto_id);
    public ComentarioPorUsuarioDTO listarUsuarioComComentario(int usuario_id);
    public ComentarioPorSentimentoDTO listarComentarioPorSentimento(int sentimento_id);
}
