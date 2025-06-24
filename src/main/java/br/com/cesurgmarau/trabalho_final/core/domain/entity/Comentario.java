package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;

@Table(name = "comentarios")
@SqlResultSetMapping(
        name = "ComentarioPorSentimentoOutputMapping",
        classes = @ConstructorResult(
                targetClass = br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput.ComentarioPorSentimentoOutput.class,
                columns = {
                        @ColumnResult(name = "sentimento", type = String.class),
                        @ColumnResult(name = "quantidade_comentarios", type = Integer.class)
                }
        )
)

@SqlResultSetMapping(
        name = "SentimentoMedioPorProdutoMapping",
        classes = @ConstructorResult(
                targetClass = br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput.MediaSentimentoProdutoOutput.class,
                columns = {
                        @ColumnResult(name = "produto", type = String.class),
                        @ColumnResult(name = "sentimento_medio", type = String.class)
                }
        )
)

@SqlResultSetMapping(
        name = "UsuarioMaisAtivoMapping",
        classes = @ConstructorResult(
                targetClass = br.com.cesurgmarau.trabalho_final.core.dto.RankingUsuarioOutput.RankingUsuarioOutput.class,
                columns = {
                        @ColumnResult(name = "posicao", type = Integer.class),
                        @ColumnResult(name = "usuario", type = String.class),
                        @ColumnResult(name = "quantidade_comentarios", type = Integer.class)
                }
        )
)

@Entity(name="comentarios")
public class Comentario {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="produto_id")
    private int produtoId;

    @Column(name="usuario_id")
    private int usuarioId;

    @Column(name="comentario")
    private String comentario;

    @Column(name="avaliacao")
    private int avaliacao;

    @Column(name="analise")
    private String analise;

    @Column(name="sentimento")
    private String sentimento;

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }
}
