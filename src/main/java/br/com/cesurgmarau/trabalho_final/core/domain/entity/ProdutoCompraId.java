package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProdutoCompraId implements Serializable {

    private Integer compraId;
    private Integer produtoId;

    public ProdutoCompraId(Integer compraId, Integer produtoId) {
        this.compraId = compraId;
        this.produtoId = produtoId;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
}
