package br.com.cesurgmarau.trabalho_final.core.dto.Comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {
    private Long id;
    private String texto;
    private TipoSentimento sentimento;
    private Double pontuacaoSentimento;
    private LocalDateTime criadoEm;
    private Long usuarioId;
    private Long produtoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoSentimento getSentimento() {
        return sentimento;
    }

    public void setSentimento(TipoSentimento sentimento) {
        this.sentimento = sentimento;
    }

    public Double getPontuacaoSentimento() {
        return pontuacaoSentimento;
    }

    public void setPontuacaoSentimento(Double pontuacaoSentimento) {
        this.pontuacaoSentimento = pontuacaoSentimento;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
