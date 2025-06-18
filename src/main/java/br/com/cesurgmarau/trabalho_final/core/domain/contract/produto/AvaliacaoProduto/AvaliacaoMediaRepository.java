package br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.AvaliacaoProduto;

import java.math.BigDecimal;

public interface AvaliacaoMediaRepository {

    BigDecimal getAvaliacaoMediaProduto (int produtoID);
    void updateAvaliacaoMediaProduto (int produtoID);

}
