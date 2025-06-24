package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {


    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insert(Produto produto) {
        var query = """
        INSERT INTO produto (nome_produto, descricao_produto) 
        VALUES (:nome_produto, :descricao_produto);
        """;
        entityManager.createNativeQuery(query)
                .setParameter("nome_produto", produto.getNomeProduto())
                .setParameter("descricao_produto", produto.getDescricaoProduto())
                .executeUpdate();
    }
    @Override
    @Transactional
    public void update(int id, Produto produto) {
        var query = """
                UPDATE produto SET nome_produto = :nome_produto, descricao_produto = :descricao_produto
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome_produto", produto.getNomeProduto())
                .setParameter("descricao_produto", produto.getDescricaoProduto())
                .executeUpdate();

    }
    @Override
    @Transactional
    public void delete(int id) {
        var query = """
                DELETE FROM produto WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .executeUpdate();
    }
    @Override
    public List<Produto> fetch() {
        var query = """
                SELECT id, nome_produto, descricao_produto FROM produto;
                """;
        return entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }
    @Override
    public Produto get(int id) {
        var query = "SELECT id, nome_produto, descricao_produto FROM produto WHERE id = :id;";
        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
