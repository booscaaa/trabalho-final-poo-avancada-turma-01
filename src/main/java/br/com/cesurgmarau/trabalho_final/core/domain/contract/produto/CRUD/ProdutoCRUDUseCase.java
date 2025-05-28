package br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.CRUD;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoCRUDUseCase {

    List<Produto> fetch ();
    Produto fetchById (int id);
    void createProduto (Produto produto);
    void updateProduto (Produto produto, int id);
    void deleteProduto (int id);



}
