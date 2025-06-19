package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompraId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoCompraRepository {
    void createProdutoCompra(ProdutoCompra produtoCompra);
    List<ProdutoCompra> readProdutoCompra();
    ProdutoCompra readProdutoCompra(Integer compraId, Integer produtoId);
    void updateProdutoCompra(Integer compraId, Integer produtoId, ProdutoCompra produtoCompra);
    void deleteProdutoCompra(Integer compraId, Integer produtoId);
}
