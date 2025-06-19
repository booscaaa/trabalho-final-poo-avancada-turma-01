package br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    void adicionarComentario(Comentario comentario);
    List<Comentario> listarComentarios();
    Comentario comentarioPorId(int id);
    List<Comentario> buscaPorProdutoId(int produtoId);
    List<Comentario> buscaPorUsuarioId(int produtoId);
    List<Comentario> buscaPorSentimento(String sentimento);
}
