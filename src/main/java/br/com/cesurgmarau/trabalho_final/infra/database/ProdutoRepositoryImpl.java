package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager.find(Produto.class, id));
    }

    @Override
    public List<Produto> buscarTodos() {
        return List.of();
    }

    @Override
    public Produto atualizar(Produto produto) {
        return null;
    }

    @Override
    public Produto salvar(Produto produto) {
        if (produto.getId() == null) {
            entityManager.persist(produto);
            return produto;
        } else {
            return entityManager.merge(produto);
        }
    }

    @Override
    public void deletar(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
}



