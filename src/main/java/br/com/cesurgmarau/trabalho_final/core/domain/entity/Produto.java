package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity(name = "produto")
public class Produto {
    @Id @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor")
    private double valor;
    @Column(name = "descricao")
    private String descricao;
}
