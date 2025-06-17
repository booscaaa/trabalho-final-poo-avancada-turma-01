package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioSentimentosResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioUsecaseImpl implements RelatorioUsecase {

    private final RelatorioRepository relatorioRepository;

    public RelatorioUsecaseImpl(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    @Override
    public List<RelatorioSentimentosResponse> totalComentariosPorSentimento() {
        return relatorioRepository.totalComentariosPorSentimento();
    }

    @Override
    public List<RelatorioProdutoResponse> mediaSentimentoPorProduto() {
        return relatorioRepository.mediaSentimentoPorProduto();
    }

    @Override
    public List<RelatorioUsuarioResponse> rankingUsuariosMaisAtivos() {
        return relatorioRepository.rankingUsuariosMaisAtivos();
    }
}
