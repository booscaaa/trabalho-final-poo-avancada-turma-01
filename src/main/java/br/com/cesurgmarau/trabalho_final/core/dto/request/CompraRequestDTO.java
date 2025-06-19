package br.com.cesurgmarau.trabalho_final.core.dto.request;

import java.util.List;

public class CompraRequestDTO {
    private Integer valorTotal;
    private Integer usuarioId;
    private List<ProdutoCompraRequestDTO> produtos;

    public CompraRequestDTO(Integer valorTotal, Integer usuarioId, List<ProdutoCompraRequestDTO> produtos) {
        this.valorTotal = valorTotal;
        this.usuarioId = usuarioId;
        this.produtos = produtos;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ProdutoCompraRequestDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCompraRequestDTO> produtos) {
        this.produtos = produtos;
    }
}
