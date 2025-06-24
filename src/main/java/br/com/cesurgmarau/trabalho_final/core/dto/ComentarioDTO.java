package br.com.cesurgmarau.trabalho_final.core.dto;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ComentarioDTO {
    private String assunto;
    private String descricao;
    private Usuario usuario;
    private Produto produto;
}
