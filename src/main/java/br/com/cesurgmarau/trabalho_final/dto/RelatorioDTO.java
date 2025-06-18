package br.com.cesurgmarau.trabalho_final.dto;

import java.util.Map;

public class RelatorioDTO {
    private Map<Integer, Long> sentimentoPorProduto;
    private Map<Integer, Long> sentimentoPorUsuario;
    private String produtoDestaque;
    private String usuarioDestaque;

    public RelatorioDTO(Map<Integer, Long> sentimentoPorProduto, Map<Integer, Long> sentimentoPorUsuario, String produtoDestaque, String usuarioDestaque) {
        this.sentimentoPorProduto = sentimentoPorProduto;
        this.sentimentoPorUsuario = sentimentoPorUsuario;
        this.produtoDestaque = produtoDestaque;
        this.usuarioDestaque = usuarioDestaque;
    }

    public Map<Integer, Long> getSentimentoPorProduto() {
        return sentimentoPorProduto;
    }

    public void setSentimentoPorProduto(Map<Integer, Long> sentimentoPorProduto) {
        this.sentimentoPorProduto = sentimentoPorProduto;
    }

    public String getUsuarioDestaque() {
        return usuarioDestaque;
    }

    public void setUsuarioDestaque(String usuarioDestaque) {
        this.usuarioDestaque = usuarioDestaque;
    }

    public String getProdutoDestaque() {
        return produtoDestaque;
    }

    public void setProdutoDestaque(String produtoDestaque) {
        this.produtoDestaque = produtoDestaque;
    }

    public Map<Integer, Long> getSentimentoPorUsuario() {
        return sentimentoPorUsuario;
    }

    public void setSentimentoPorUsuario(Map<Integer, Long> sentimentoPorUsuario) {
        this.sentimentoPorUsuario = sentimentoPorUsuario;
    }
}
