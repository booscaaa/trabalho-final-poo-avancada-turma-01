package br.com.cesurgmarau.trabalho_final.core.dto;

public class ComentarioRequestDto {
    private String texto;
    private int livroId;
    private int usuarioId;

    public ComentarioRequestDto() {
    }

    public ComentarioRequestDto(String texto, int livroId, int usuarioId) {
        this.texto = texto;
        this.livroId = livroId;
        this.usuarioId = usuarioId;

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

}
