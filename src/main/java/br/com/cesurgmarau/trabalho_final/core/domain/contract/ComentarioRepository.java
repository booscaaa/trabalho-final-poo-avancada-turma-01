package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository {

    Comentario salvar(Comentario comentario);

    Optional<Comentario> buscarPorId(Long id);

    List<Comentario> buscarTodos();

    List<Comentario> buscarPorProdutoId(Long produtoId);

    List<Comentario> buscarPorUsuarioId(Long usuarioId);

    List<Comentario> buscarPorSentimento(TipoSentimento sentimento);

    void deletar(Long id);
}

