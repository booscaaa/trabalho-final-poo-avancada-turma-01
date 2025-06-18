package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    public void adicionarProduto (Produto produto);
    public Produto listarProdutoPorId(int id);
    public List<Produto> listarProdutos();
    public void deletarProduto (int id);
    public void atualizarProduto(int id, Produto produto);
    public List<Produto> listarProdutosPorCategoria(int categoriaId);
    public void adicionarQuantidadeComentario(int id);
}
