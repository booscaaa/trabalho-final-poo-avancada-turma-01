package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoContracts.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void adicionarProduto(Produto produto) {
        var query = """
                    INSERT INTO produtos (nome, preco, descricao)
                    VALUES (
                        :nome,
                        :preco,
                        :descricao
                    )
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("preco", produto.getPreco())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();
    }

    @Override
    public List<Produto> listarProdutos() {
        var query = "SELECT * FROM produtos";
        return (List<Produto>) entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }

    @Override
    public Produto produtoPorID(int id) {
        var query = """
                    SELECT * FROM produtos WHERE produto_id = :id;
                """;
        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void atualizarProduto(int id, Produto produto) {
        var query = """
                    UPDATE produtos
                    SET nome = :nome,
                    preco = :preco,
                    descricao = :descricao
                    WHERE produto_id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .setParameter("nome", produto.getNome())
                .setParameter("preco", produto.getPreco())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();
    }

    @Override
    public void deletarProduto(int id) {
        var query = """
                    DELETE FROM produtos WHERE produto_id = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
