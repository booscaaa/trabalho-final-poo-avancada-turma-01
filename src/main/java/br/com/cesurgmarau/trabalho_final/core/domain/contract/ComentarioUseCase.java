package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;

import java.util.List;
import java.util.Optional;

public interface ComentarioUseCase {

    Comentario criarComentario(Comentario comentario);

    Optional<Comentario> buscarPorId(Long id);

    List<Comentario> listarTodos();

    List<Comentario> buscarPorProdutoId(Long produtoId);

    List<Comentario> buscarPorUsuarioId(Long usuarioId);

    List<Comentario> buscarPorSentimento(TipoSentimento sentimento);
}
