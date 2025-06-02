package br.com.cesurgmarau.trabalho_final.Core.domain.contract.UseCase;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Produtos;

import java.util.List;

public interface ProdutosUseCase {
    List<Produtos> fetch ();
    Produtos fetchById (int id);
    void createProduto (Produtos produto);
    void updateProduto (Produtos produto, int id);
    void deleteProduto (int id);
}
