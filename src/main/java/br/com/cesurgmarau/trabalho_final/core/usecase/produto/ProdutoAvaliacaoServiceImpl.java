package br.com.cesurgmarau.trabalho_final.core.usecase.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.AvaliacaoProduto.AvaliacaoMediaRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.AvaliacaoProduto.AvaliacaoMediaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoAvaliacaoServiceImpl implements AvaliacaoMediaUseCase {

    @Autowired
    AvaliacaoMediaRepository avaliacaoMediaRepository;

    @Override
    public BigDecimal getAvaliacaoMediaProduto(int produtoID) {
        return avaliacaoMediaRepository.getAvaliacaoMediaProduto(produtoID);
    }

    @Override
    public void updateAvaliacaoMediaProduto(int produtoID) {
        avaliacaoMediaRepository.updateAvaliacaoMediaProduto(produtoID);
    }
}
