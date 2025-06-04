package br.com.cesurgmarau.trabalho_final.core.dto.request;

import java.util.List;

public class CompraRequestDTO {
    private int valorTotal;
    private int usuarioId;
    private List<ProdutoCompraRequestDTO> produtos;

    public CompraRequestDTO(int valorTotal, int usuarioId, List<ProdutoCompraRequestDTO> produtos) {
        this.valorTotal = valorTotal;
        this.usuarioId = usuarioId;
        this.produtos = produtos;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ProdutoCompraRequestDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCompraRequestDTO> produtos) {
        this.produtos = produtos;
    }
}
