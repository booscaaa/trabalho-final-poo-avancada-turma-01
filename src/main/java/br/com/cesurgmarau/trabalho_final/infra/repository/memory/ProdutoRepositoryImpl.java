package br.com.cesurgmarau.trabalho_final.infra.repository.memory;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarProduto(Produto produto) {
        var query = """
                INSERT INTO produtos ( nome, descricao, preco)
                VALUES (:nome, :descricao, :preco)
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("preco", produto.getPreco())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarProduto(int id, Produto produto) {
        var query = """
                UPDATE produtos SET
                nome = :nome,
                descricao = :descricao,
                preco = :preco
                WHERE id = :id
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("preco", produto.getPreco())
                .setParameter("id", id)
                .executeUpdate();

        return "Produto atualizado com sucesso!";
    }

    @Transactional
    @Override
    public String deletarProduto(int id) {
        var query = "DELETE FROM produtos WHERE id = :id";

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .executeUpdate();

        return "Produto removido com sucesso!";
    }

    @Override
    public List<Produto> listar() {
        var query = "SELECT * FROM produtos";

        return (List<Produto>) entityManager
                .createNativeQuery(query, Produto.class)
                .getResultList();
    }

    @Override
    public Produto listarPorId(int id) {
        var query = "SELECT * FROM produtos WHERE id = :id";

        return (Produto) entityManager
                .createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
