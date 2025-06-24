package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ProdutoRepositoryIMPL implements ProdutoRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void cadastrarProduto(Produto produto) {
        String query = "INSERT INTO produto(nome, valor, descricao) VALUES(:nome, :valor, :descricao)";

        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("valor", produto.getValor())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();
    }

    @Override
    public List<Produto> listarProdutos() {
        String query = "SELECT * FROM produto";

        return entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }

    @Override
    public Produto getId(Long id) {
        String query = "SELECT * FROM produto WHERE id = :id";

        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void atualizarProduto(Produto produto, Long id) {
        String query = "UPDATE produto SET(nome, valor, descricao) = (:nome, :valor, :descricao) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("valor", produto.getValor())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deletaProduto(Long id) {
        String query = "DELETE FROM produto WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();

    }
}
