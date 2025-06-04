package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;

import java.util.List;

public interface ProdutoCompraRepository {
    void createProdutoCompra(ProdutoCompra produtoCompra);
    List<ProdutoCompra> readProdutoCompra();
    ProdutoCompra readProdutoCompra(int compraId, int produtoId);
    void updateProdutoCompra(int id, ProdutoCompra produtoCompra);
    void deleteProdutoCompra(int compraId, int produtoId);
}
