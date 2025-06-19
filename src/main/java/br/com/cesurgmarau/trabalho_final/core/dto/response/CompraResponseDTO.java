package br.com.cesurgmarau.trabalho_final.core.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class CompraResponseDTO {
    private Integer id;
    private LocalDateTime data;
    private Integer valorTotal;
    private Integer usuarioId;
    private String usuarioNome;
    private List<ProdutoCompraResponseDTO> produtos;

    public CompraResponseDTO(Integer id, LocalDateTime data, Integer valorTotal, Integer usuarioId, String usuarioNome, List<ProdutoCompraResponseDTO> produtos) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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
