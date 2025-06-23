package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Produto salvar(Produto produto) {
        var query = """
            INSERT INTO produtos (nome, descricao)
            VALUES (:nome, :descricao)
        """;

        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();

        return produto;
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        var query = "SELECT * FROM produtos WHERE id = :id";
        List<Produto> resultado = entityManager
                .createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getResultList();

        return resultado.stream().findFirst();
    }

    @Override
    public List<Produto> listarTodos() {
        var query = "SELECT * FROM produtos";
        return entityManager.createNativeQuery(query, Produto.class).getResultList();
    }

    @Override
    @Transactional
    public Produto atualizar(Produto produto) {
        var query = """
            UPDATE produtos
            SET nome = :nome,
                descricao = :descricao
            WHERE id = :id
        """;

        entityManager.createNativeQuery(query)
                .setParameter("nome", produto.getNome())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("id", produto.getId())
                .executeUpdate();

        return produto;
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        var query = "DELETE FROM produtos WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
