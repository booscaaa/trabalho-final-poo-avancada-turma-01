package br.com.cesurgmarau.trabalho_final.core.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CompraRequestDTO {

    @NotNull(message = "O campo 'valor total' é obrigatório.")
    private Integer valorTotal;

    @NotNull(message = "O campo 'usuario id' é obrigatório.")
    private Integer usuarioId;

    @NotNull(message = "O campo 'produtos' é obrigatório.")
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
