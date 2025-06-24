package br.com.cesurgmarau.trabalho_final.core.dto.request;

import jakarta.validation.constraints.NotNull;

public class ComentarioRequestDTO {

    @NotNull(message = "O campo 'texto' é obrigatório.")
    private String texto;

    @NotNull(message = "O campo 'usuario id' é obrigatório.")
    private Integer usuarioId;

    @NotNull(message = "O campo 'produto id' é obrigatório.")
    private Integer produtoId;

    private Integer sentimento;

    public ComentarioRequestDTO(String texto, Integer usuarioId, Integer produtoId, Integer sentimento) {
        this.texto = texto;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.sentimento = sentimento;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getSentimento() {
        return sentimento;
    }

    public void setSentimento(Integer sentimento) {
        this.sentimento = sentimento;
    }
}
