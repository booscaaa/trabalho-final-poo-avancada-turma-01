package br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoUseCase {
    public void create(Produto produto);
    public void update(int id,Produto produto);
    public void delete(int id);
    public Produto findById(int id);
    public List<Produto> fetch();
}
