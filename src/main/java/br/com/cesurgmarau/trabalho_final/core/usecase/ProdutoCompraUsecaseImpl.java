package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ProdutoCompraRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ProdutoCompraUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCompraUsecaseImpl implements ProdutoCompraUseCase {

    @Autowired
    ProdutoCompraRepository produtoCompraRepository;

    @Override
    public void createProdutoCompra(ProdutoCompra produtoCompra) {
        produtoCompraRepository.createProdutoCompra(produtoCompra);
    }

    @Override
    public List<ProdutoCompra> readProdutoCompra() {
        return produtoCompraRepository.readProdutoCompra();
    }

    @Override
    public ProdutoCompra readProdutoCompra(Integer compraId, Integer produtoId) {
        return produtoCompraRepository.readProdutoCompra(compraId, produtoId);
    }

    @Override
    public void updateProdutoCompra(Integer compraId, Integer produtoId, ProdutoCompra produtoCompra) {
        produtoCompraRepository.updateProdutoCompra(compraId, produtoId, produtoCompra);
    }

    @Override
    public void deleteProdutoCompra(Integer compraId, Integer produtoId) {
        produtoCompraRepository.deleteProdutoCompra(compraId, produtoId);
    }
}
