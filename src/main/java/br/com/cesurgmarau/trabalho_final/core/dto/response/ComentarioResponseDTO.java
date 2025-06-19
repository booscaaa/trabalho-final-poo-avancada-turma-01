package br.com.cesurgmarau.trabalho_final.core.dto.response;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {
    private Integer id;
    private String texto;
    private Integer usuarioId;
    private Integer produtoId;
    private Integer sentimento;
    private LocalDateTime data;

    public ComentarioResponseDTO(Integer id, String texto, Integer usuarioId, Integer produtoId, Integer sentimento, LocalDateTime data) {
        this.id = id;
        this.texto = texto;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.sentimento = sentimento;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
