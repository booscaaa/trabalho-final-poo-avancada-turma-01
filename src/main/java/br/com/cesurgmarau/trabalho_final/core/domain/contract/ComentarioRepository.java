package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioRepository {
    Comentario salvar(Comentario comentario);
    Optional<Comentario> buscarPorId(Integer id);
    List<Comentario> listarTodos();
    List<Comentario> buscarPorProdutoId(Integer produtoId);
    List<Comentario> buscarPorUsuarioId(Integer usuarioId);
    List<Comentario> buscarPorSentimento(String sentimento);
    Comentario atualizar(Comentario comentario);
    void deletar(Integer id);
}
