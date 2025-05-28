package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CategoriaRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarCategoria(Categoria categoria) {
        var query = """
                INSERT INTO categoria_produto (nome)
                VALUES (:nome)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", categoria.getNome())
                .executeUpdate();
    }

    @Override
    public List<Categoria> listarCategoria() {
        var query = """
                SELECT * FROM categoria_produto;
                """;
        return entityManager.createNativeQuery(query, Categoria.class).getResultList();
    }

    @Transactional
    @Override
    public void deletarCategoria(int id) {
        var query = """
                DELETE FROM categoria_produto WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Categoria.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarCategoria(int id, Categoria categoria) {
        var query = """
                UPDATE categoria_produto SET
                nome = :nome
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Categoria.class)
                .setParameter("nome", categoria.getNome())
                .setParameter("id", id)
                .executeUpdate();
    }
}
