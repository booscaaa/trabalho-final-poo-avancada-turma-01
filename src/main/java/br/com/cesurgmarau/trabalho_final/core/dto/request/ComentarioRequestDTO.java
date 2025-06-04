package br.com.cesurgmarau.trabalho_final.core.dto.request;

public class ComentarioRequestDTO {
    private String texto;
    private int usuarioId;
    private int produtoId;
    private int sentimento;

    public ComentarioRequestDTO(String texto, int usuarioId, int produtoId, int sentimento) {
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

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getSentimento() {
        return sentimento;
    }

    public void setSentimento(int sentimento) {
        this.sentimento = sentimento;
    }
}
