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
@Transactional
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Produto salvar(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        Produto produto = entityManager.find(Produto.class, id);
        return Optional.ofNullable(produto);
    }

    @Override
    public List<Produto> listarTodos() {
        return entityManager.createQuery(
                        """
                        SELECT p FROM Produto p
                        """, Produto.class)
                .getResultList();
    }

    @Override
    public Produto atualizar(Produto produto) {
        return entityManager.merge(produto);
    }

    @Override
    public void remover(Integer id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
}
