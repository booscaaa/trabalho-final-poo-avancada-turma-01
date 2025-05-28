package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;

import java.util.List;

public interface CategoriaUseCase {
    public void adicionarCategoria (Categoria categoria);
    public List<Categoria> listarCategoria();
    public void deletarCategoria (int id);
    public void atualizarCategoria(int id, Categoria categoria);
}
