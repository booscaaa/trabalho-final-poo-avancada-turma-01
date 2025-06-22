package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioUsecase {
    Comentario criar(ComentarioRequest request);
    Comentario buscarPorId(Integer id);
    List<Comentario> listarTodos();
    List<Comentario> buscarPorProdutoId(Integer produtoId);
    List<Comentario> buscarPorUsuarioId(Integer usuarioId);
    List<Comentario> buscarPorSentimento(String sentimento);
    List<Comentario> buscarFiltrado(Integer produtoId, Integer usuarioId, String sentimento);
    void deletar(Integer id);
}
