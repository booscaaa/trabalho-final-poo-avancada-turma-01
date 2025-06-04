package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;

import java.util.List;
import java.util.Optional;

public class ComentarioUseCaseImpl implements ComentarioUseCase {


    @Override
    public Comentario criarComentario(Comentario comentario) {
        return null;
    }

    @Override
    public Optional<Comentario> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Comentario> listarTodos() {
        return List.of();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Long produtoId) {
        return List.of();
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Long usuarioId) {
        return List.of();
    }

    @Override
    public List<Comentario> buscarPorSentimento(TipoSentimento sentimento) {
        return List.of();
    }
}
