package br.com.cesurgmarau.trabalho_final.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDTO {
    private String nome;
    private double valor;
    private String descricao;
}
