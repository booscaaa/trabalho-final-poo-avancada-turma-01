package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoCompraId implements Serializable {

    private Integer compraId;
    private Integer produtoId;

    public ProdutoCompraId() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoCompraId)) return false;
        ProdutoCompraId that = (ProdutoCompraId) o;
        return compraId == that.compraId && produtoId == that.produtoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compraId, produtoId);
    }
}
