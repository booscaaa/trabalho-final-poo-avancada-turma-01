package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroUseCaseImpl implements LivroUseCase {

    @Autowired
    private LivroRepository livroRepository;


    @Override
    public void insert(Livro livro) {
        livroRepository.insert(livro);
    }

    @Override
    public void update(int id, Livro livro) {
        livroRepository.update(id, livro);
    }

    @Override
    public void delete(int id) {
        livroRepository.delete(id);
    }

    @Override
    public List<Livro> fetch() {
        return livroRepository.fetch();
    }

    @Override
    public Livro get(int id) {
        return livroRepository.get(id);
    }
}
