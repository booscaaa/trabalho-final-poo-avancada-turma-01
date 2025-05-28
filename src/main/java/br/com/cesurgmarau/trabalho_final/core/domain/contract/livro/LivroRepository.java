package br.com.cesurgmarau.trabalho_final.core.domain.contract.livro;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;

import java.util.List;

public interface LivroRepository {
    public void insert (Livro livro);
    public void update (int id, Livro livro);
    public void delete (int id);
    public List<Livro> fetch();
    public Livro get (int id);
}


