package br.com.cesurgmarau.trabalho_final.core.usecase.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosProduto.RelatoriosProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosProduto.RelatoriosProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput.MediaSentimentoProdutoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoriosProdutoServiceImpl implements RelatoriosProdutoUseCase {

    @Autowired
    RelatoriosProdutoRepository relatoriosProdutoRepository;

    @Override
    public List<MediaSentimentoProdutoOutput> mediaDeSentimentoPorProduto() {
        return relatoriosProdutoRepository.mediaDeSentimentoPorProduto();
    }
}
