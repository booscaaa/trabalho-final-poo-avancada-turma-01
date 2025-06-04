package br.com.cesurgmarau.trabalho_final.core.mapper;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoCompraResponseDTO;

public class ProdutoCompraMapper {
    public static ProdutoCompra toEntity(Compra compra, Produto produto, int quantidade) {
        return new ProdutoCompra(compra, produto, quantidade);
    }

    public static ProdutoCompraResponseDTO toResponseDTO(ProdutoCompra produtoCompra) {
        return new ProdutoCompraResponseDTO(
                produtoCompra.getProduto().getId(),
                produtoCompra.getProduto().getNome(),
                produtoCompra.getQuantidade()
        );
    }
}
