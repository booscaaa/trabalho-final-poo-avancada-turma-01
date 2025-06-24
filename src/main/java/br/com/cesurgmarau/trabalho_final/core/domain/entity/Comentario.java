package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity(name = "comentario")
public class Comentario {
    @Id @Column(name = "id")
    private Long id;
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "descricao")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
