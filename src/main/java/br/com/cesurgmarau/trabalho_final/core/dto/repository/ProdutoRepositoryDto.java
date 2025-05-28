package br.com.cesurgmarau.trabalho_final.core.dto.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.xml.crypto.Data;

@Entity
@Table(name="produto")
public class ProdutoRepositoryDto {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="nome", length=100, nullable=false)
    private String nome;

    @Column(name="valor_unitario", nullable=false)
    private int valorUnitario;

    @Column(name="unidade", nullable=false)
    private int unidade;

    @Column(name="descricao", length=100, nullable=false)
    private String descricao;

    @Column(name="quantidade")
    private int quantidade;

    @Column(name="data")
    private Data data;
}
