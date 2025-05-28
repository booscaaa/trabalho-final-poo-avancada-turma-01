package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
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
    public void adicionarProduto(Produto produto) {
        var query = """
                INSERT INTO produto (nome, categoria_id)
                VALUES (:nome, :categoria_id)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("categoria_id", produto.getCategoriaId())
                .executeUpdate();
    }

    @Override
    public Produto listarProdutoPorId(int id) {
        var query = """
                SELECT * FROM produto WHERE id = :id;
                """;
        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Produto> listarProdutos() {
        var query = """
                SELECT * FROM produto;
                """;
        return entityManager.createNativeQuery(query, Produto.class).getResultList();
    }

    @Transactional
    @Override
    public void deletarProduto(int id) {
        var query = """
                DELETE FROM produto WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarProduto(int id, Produto produto) {
        var query = """
                UPDATE produto SET
                nome = :nome,
                categoria_id = :categoria_id
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", produto.getNome())
                .setParameter("categoria_id", produto.getCategoriaId())
                .setParameter("id", id)
                .executeUpdate();
    }
}
