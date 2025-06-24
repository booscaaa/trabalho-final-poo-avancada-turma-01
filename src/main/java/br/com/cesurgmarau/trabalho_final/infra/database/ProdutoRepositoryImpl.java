package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ProdutoRepository;
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
    public void createProduto(Produto produto) {
        String query = "INSERT INTO produto (nome, valor_unitario, unidade, descricao, quantidade) VALUES (:nome, :valor_unitario, :unidade, :descricao, :quantidade)";

        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("valor_unitario", produto.getValorUnitario())
                .setParameter("unidade", produto.getUnidade())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("quantidade", produto.getQuantidade())
                .executeUpdate();
    }

    @Override
    public List<Produto> readProduto() {
        String query = "SELECT * FROM produto";

        return entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }

    @Override
    public Produto readProduto(Integer id) {
        String query = "SELECT * FROM produto WHERE id = :id";

        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void updateProduto(Integer id, Produto produto) {
        String query = "UPDATE produto SET (nome, valor_unitario, unidade, descricao, quantidade) = (:nome, :valor_unitario, :unidade, :descricao, :quantidade) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("valor_unitario", produto.getValorUnitario())
                .setParameter("unidade", produto.getUnidade())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("quantidade", produto.getQuantidade())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteProduto(Integer id) {
        String query = "DELETE FROM produto WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();

    }
}
