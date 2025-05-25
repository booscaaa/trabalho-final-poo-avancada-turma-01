package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface ProdutoRepository {
    public void adicionarProduto (Produto produto);
    public Produto listarProdutoPorId(int id);
    public List<Produto> listarProdutos();
    public void deletarProduto (int id);
    public void atualizarProduto(int id, Produto produto);
}
