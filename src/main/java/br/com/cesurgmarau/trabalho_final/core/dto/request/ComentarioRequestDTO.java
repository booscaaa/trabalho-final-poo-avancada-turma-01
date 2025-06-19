package br.com.cesurgmarau.trabalho_final.core.dto.request;

public class ComentarioRequestDTO {
    private String texto;
    private Integer usuarioId;
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
