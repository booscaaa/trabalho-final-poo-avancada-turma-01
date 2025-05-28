package br.com.cesurgmarau.trabalho_final.core.dto.repository;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="produto_compra")
public class ProdutoCompraRepositoryDto {
    @EmbeddedId
    private ProdutoCompraId id;

    @Column(name="quantidade")
    private int quantidade;
}