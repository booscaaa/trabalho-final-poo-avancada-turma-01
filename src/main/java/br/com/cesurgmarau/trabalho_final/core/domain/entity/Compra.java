package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "compra")
public class Compra {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    private LocalDateTime data;
    @Column(name = "valor_total")
    private Integer valorTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ProdutoCompra> produtos;

    public Compra(Integer id, LocalDateTime data, Integer valorTotal, Usuario usuario, List<ProdutoCompra> produtos) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
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

