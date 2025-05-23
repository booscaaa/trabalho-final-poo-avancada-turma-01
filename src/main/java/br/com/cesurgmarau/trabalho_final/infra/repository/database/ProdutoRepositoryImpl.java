package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void create(Produto produto) {
        var query = """
                INSERT INTO produto (nome, preco)
                VALUES (:nome, :preco);
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("preco", produto.getPreco())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Produto produto) {
        var query = """
                UPDATE produto
                SET nome = :nome, preco = :preco
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("preco", produto.getPreco())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM produto
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Produto findById(int id) {
        var query = """
                SELECT * FROM produto
                WHERE id = :id;
                """;
        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Produto> fetch() {
        var query = """
                SELECT * FROM produto;
                """;
        return entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }
}
