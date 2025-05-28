package br.com.cesurgmarau.trabalho_final.core.dto.repository;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProdutoCompraId implements Serializable {
    private int compraId;
    private int produtoId;

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
}