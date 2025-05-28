package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CategoriaRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.CategoriaUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUseCaseImpl implements CategoriaUseCase {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void adicionarCategoria(Categoria categoria) {
        categoriaRepository.adicionarCategoria(categoria);
    }

    @Override
    public List<Categoria> listarCategoria() {
        return categoriaRepository.listarCategoria();
    }

    @Override
    public void deletarCategoria(int id) {
        categoriaRepository.deletarCategoria(id);
    }

    @Override
    public void atualizarCategoria(int id, Categoria categoria) {
        categoriaRepository.atualizarCategoria(id, categoria);
    }
}
