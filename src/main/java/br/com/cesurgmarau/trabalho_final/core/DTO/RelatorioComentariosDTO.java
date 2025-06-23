package br.com.cesurgmarau.trabalho_final.core.DTO;

import java.util.List;
import java.util.Map;

public class RelatorioComentariosDTO {
    private Map<String, Long> totalPorSentimento;
    private Map<String, Double> mediaSentimentoPorProduto;
    private List<UsuarioRankingDTO> usuariosMaisAtivos;

    public Map<String, Long> getTotalPorSentimento() {
        return totalPorSentimento;
    }

    public void setTotalPorSentimento(Map<String, Long> totalPorSentimento) {
        this.totalPorSentimento = totalPorSentimento;
    }

    public Map<String, Double> getMediaSentimentoPorProduto() {
        return mediaSentimentoPorProduto;
    }

    public void setMediaSentimentoPorProduto(Map<String, Double> mediaSentimentoPorProduto) {
        this.mediaSentimentoPorProduto = mediaSentimentoPorProduto;
    }

    public List<UsuarioRankingDTO> getUsuariosMaisAtivos() {
        return usuariosMaisAtivos;
    }

    public void setUsuariosMaisAtivos(List<UsuarioRankingDTO> usuariosMaisAtivos) {
        this.usuariosMaisAtivos = usuariosMaisAtivos;
    }
}
