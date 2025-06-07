package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;

import java.util.List;

public interface ComentarioUsecase {
    ComentarioResponse criar(ComentarioRequest request);
    ComentarioResponse buscarPorId(Integer id);
    List<ComentarioResponse> listarTodos();
    List<ComentarioResponse> buscarPorProdutoId(Integer produtoId);
    List<ComentarioResponse> buscarPorUsuarioId(Integer usuarioId);
    List<ComentarioResponse> buscarPorSentimento(String sentimento);
    List<ComentarioResponse> buscarFiltrado(Integer produtoId, Integer usuarioId, String sentimento);
}
