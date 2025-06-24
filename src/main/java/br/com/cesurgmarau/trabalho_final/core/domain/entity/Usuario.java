package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity(name = "usuario")
public class Usuario {
    @Id @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private int idade;


}
