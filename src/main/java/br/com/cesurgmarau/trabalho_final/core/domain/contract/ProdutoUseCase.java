package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoUseCase {
    public void insert (Produto produto);
    public void update (int id, Produto produto);
    public void delete (int id);
    public List<Produto> fetch ();
    public Produto get (int id);
}
