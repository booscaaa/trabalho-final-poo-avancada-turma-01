package br.com.cesurgmarau.trabalho_final.core.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class CompraResponseDTO {
    private int id;
    private LocalDateTime data;
    private int valorTotal;
    private int usuarioId;
    private String usuarioNome;
    private List<ProdutoCompraResponseDTO> produtos;

    public CompraResponseDTO(int id, LocalDateTime data, int valorTotal, int usuarioId, String usuarioNome, List<ProdutoCompraResponseDTO> produtos) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public List<ProdutoCompraResponseDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCompraResponseDTO> produtos) {
        this.produtos = produtos;
    }
}
