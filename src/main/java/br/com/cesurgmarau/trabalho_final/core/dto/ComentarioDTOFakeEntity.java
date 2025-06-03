package br.com.cesurgmarau.trabalho_final.core.dto;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "ComentarioDTOMapping",
        classes = @ConstructorResult(
                targetClass = ComentarioDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "usuario_id", type = Integer.class),
                        @ColumnResult(name = "produto_id", type = Integer.class),
                        @ColumnResult(name = "comentario", type = String.class),
                        @ColumnResult(name = "sentimento_id", type = Integer.class),
                        @ColumnResult(name = "nome", type = String.class),
                }
        )
)
@Entity
public class ComentarioDTOFakeEntity {
    @Id
    private int id;
}