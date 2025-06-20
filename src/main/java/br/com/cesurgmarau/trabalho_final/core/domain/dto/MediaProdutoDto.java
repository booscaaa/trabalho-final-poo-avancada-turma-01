package br.com.cesurgmarau.trabalho_final.core.domain.dto;

public class MediaProdutoDto {
    private String nomeProduto;
    private double media;

    public MediaProdutoDto(String nomeProduto, double media){
        this.nomeProduto = nomeProduto;
        this.media = media;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
