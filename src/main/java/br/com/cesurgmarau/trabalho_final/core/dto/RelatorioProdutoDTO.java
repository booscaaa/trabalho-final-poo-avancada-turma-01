package br.com.cesurgmarau.trabalho_final.core.dto;

public class RelatorioProdutoDTO {
    private int livroId;
    private String tituloLivro;
    private double mediaSentimento;

    public RelatorioProdutoDTO(int livroId, String tituloLivro, double mediaSentimento) {
        this.livroId = livroId;
        this.tituloLivro = tituloLivro;
        this.mediaSentimento = mediaSentimento;
    }

    public int getLivroId() {
        return livroId;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public double getMediaSentimento() {
        return mediaSentimento;
    }
}
