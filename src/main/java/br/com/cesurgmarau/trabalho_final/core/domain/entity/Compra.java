package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Compra {
    private int id;
    private LocalDateTime data;
    private int valorTotal;
    private Usuario usuario;
    private List<ProdutoCompra> produtos;

    public Compra(int id, LocalDateTime data, int valorTotal, Usuario usuario, List<ProdutoCompra> produtos) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ProdutoCompra> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCompra> produtos) {
        this.produtos = produtos;
    }
}

