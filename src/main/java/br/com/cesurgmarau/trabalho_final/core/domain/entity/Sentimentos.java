package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import br.com.cesurgmarau.trabalho_final.core.domain.enums.Sentimento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity(name = "sentimento")
public class Sentimentos {
    @Id @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private Comentario comentario;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "sentimento")
    private Sentimento sentimento;
}
