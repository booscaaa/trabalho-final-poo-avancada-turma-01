package br.com.cesurgmarau.trabalho_final.core.dto;

public class ProdutoDestaqueResponse {
    private Integer id;
    private String nome;
    private Long totalSentimentosPositivos;

    public ProdutoDestaqueResponse() {
    }

    public ProdutoDestaqueResponse(Integer id, String nome, Long totalSentimentosPositivos) {
        this.id = id;
        this.nome = nome;
        this.totalSentimentosPositivos = totalSentimentosPositivos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTotalSentimentosPositivos() {
        return totalSentimentosPositivos;
    }

    public void setTotalSentimentosPositivos(Long totalSentimentosPositivos) {
        this.totalSentimentosPositivos = totalSentimentosPositivos;
    }
}
