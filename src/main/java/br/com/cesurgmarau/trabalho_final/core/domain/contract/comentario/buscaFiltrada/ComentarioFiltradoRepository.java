package br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.buscaFiltrada;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioFiltradoRepository {

    List<Comentario> filtraPorProduto (int idProduto);

    List<Comentario> filtraPorUsuario (int idUsuario);

    List<Comentario> filtraPorSentimento (String sentimento);

}