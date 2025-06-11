package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface CategoriaRepository {
    public void adicionarCategoria (Categoria categoria);
    public List<Categoria> listarCategoria();
    public void deletarCategoria (int id);
    public void atualizarCategoria(int id, Categoria categoria);
    public Categoria listarCategoriaPorId(int id);
}
