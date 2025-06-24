package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository {
    Comentario salvar(Comentario comentario);
    Optional<Comentario> buscarPorId(Integer id);
    List<Comentario> buscarTodos();
    List<Comentario> buscarPorProdutoId(Integer produtoId);
    List<Comentario> buscarPorUsuarioId(Integer usuarioId);
    List<Comentario> buscarPorSentimento(String sentimento);
    List<UsuarioDestaqueResponse> buscarUsuariosComMaisComentariosPositivos();
    List<ProdutoDestaqueResponse> buscarProdutosComMaisSentimentosPositivos();
    void deletar(Integer id);
}
