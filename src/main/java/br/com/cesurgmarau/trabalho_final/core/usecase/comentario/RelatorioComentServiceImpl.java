package br.com.cesurgmarau.trabalho_final.core.usecase.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosComentario.RelatorioComentRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosComentario.RelatorioComentUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput.ComentarioPorSentimentoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioComentServiceImpl implements RelatorioComentUseCase {

    @Autowired
    RelatorioComentRepository relatorioComentRepository;

    @Override
    public List<ComentarioPorSentimentoOutput> listaTotalComentariosPorSentimento() {
        return relatorioComentRepository.listaTotalComentariosPorSentimento();
    }
}
