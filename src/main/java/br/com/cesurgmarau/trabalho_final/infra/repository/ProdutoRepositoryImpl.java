package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return Optional.ofNullable(entityManager.find(Produto.class, id));
    }

    @Override
    public List<Produto> listarTodos() {
        return entityManager
                .createQuery("SELECT p FROM Produto p", Produto.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Produto atualizar(Produto produto) {
        return entityManager.merge(produto);
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
}
