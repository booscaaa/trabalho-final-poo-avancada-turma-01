package br.com.cesurgmarau.trabalho_final.core.domain.contract;

public interface RelatorioRepository {
    public double listarPorcentagemDeComentarioPorProdutoId(int produtoId, int sentimentoId);
    public double listarPorcentagemDeComentario(int sentimentoId);
}
