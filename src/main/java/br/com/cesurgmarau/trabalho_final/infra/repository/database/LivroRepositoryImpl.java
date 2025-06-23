package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Livro livro) {
        var query = """
                INSERT INTO livro (titulo, autor, descricao, preco)
                VALUES (:titulo, :autor, :descricao, :preco);
                """;
        entityManager.createNativeQuery(query, Livro.class)
                .setParameter("titulo", livro.getTitulo())
                .setParameter("autor", livro.getAutor())
                .setParameter("descricao", livro.getDescricao())
                .setParameter("preco", livro.getPreco())
                .executeUpdate();
    }
    @Transactional
    public void update(int id, Livro livro) {
        var query = """
                UPDATE livro SET 
                titulo = :titulo, autor = :autor, descricao = :descricao, preco = :preco
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Livro.class)
                .setParameter("titulo", livro.getTitulo())
                .setParameter("autor", livro.getAutor())
                .setParameter("descricao", livro.getDescricao())
                .setParameter("preco", livro.getPreco())
                .setParameter("id", id)
                .executeUpdate();
    }
    @Transactional
    public void delete(int id) {
        var query = "DELETE FROM livro WHERE id = :id";
        entityManager.createNativeQuery(query).setParameter("id", id).executeUpdate();
    }
    public List<Livro> fetch() {
        var query = "SELECT * FROM livro;";
        return entityManager.createNativeQuery(query, Livro.class).getResultList();
    }
    public Livro get(int id) {
        var query = "SELECT * FROM livro WHERE id = :id;";
        return (Livro) entityManager.createNativeQuery(query, Livro.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Livro> buscarTodos() {
        return null;
    }
}
