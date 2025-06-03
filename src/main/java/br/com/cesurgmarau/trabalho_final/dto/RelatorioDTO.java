package br.com.cesurgmarau.trabalho_final.dto;

import java.util.Map;

public class RelatorioDTO {

    private Map<String, Long> sentimentoPorProduto;
    private Map<String, Long> sentimentoPorUsuario;
    private String produtoDestaque;
    private String usuarioDestaque;

    public RelatorioDTO() {}

    public RelatorioDTO(Map<String, Long> sentimentoPorProduto, Map<String, Long> sentimentoPorUsuario,
                        String produtoDestaque, String usuarioDestaque) {
        this.sentimentoPorProduto = sentimentoPorProduto;
        this.sentimentoPorUsuario = sentimentoPorUsuario;
        this.produtoDestaque = produtoDestaque;
        this.usuarioDestaque = usuarioDestaque;
    }

    public Map<String, Long> getSentimentoPorProduto() {
        return sentimentoPorProduto;
    }

    public void setSentimentoPorProduto(Map<String, Long> sentimentoPorProduto) {
        this.sentimentoPorProduto = sentimentoPorProduto;
    }

    public Map<String, Long> getSentimentoPorUsuario() {
        return sentimentoPorUsuario;
    }

    public void setSentimentoPorUsuario(Map<String, Long> sentimentoPorUsuario) {
        this.sentimentoPorUsuario = sentimentoPorUsuario;
    }

    public String getProdutoDestaque() {
        return produtoDestaque;
    }

    public void setProdutoDestaque(String produtoDestaque) {
        this.produtoDestaque = produtoDestaque;
    }

    public String getUsuarioDestaque() {
        return usuarioDestaque;
    }

    public void setUsuarioDestaque(String usuarioDestaque) {
        this.usuarioDestaque = usuarioDestaque;
    }
}