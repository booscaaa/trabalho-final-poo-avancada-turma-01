package br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosComentario;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput.ComentarioPorSentimentoOutput;

import java.util.List;

public interface RelatorioComentRepository {

    List<ComentarioPorSentimentoOutput> listaTotalComentariosPorSentimento ();

}
