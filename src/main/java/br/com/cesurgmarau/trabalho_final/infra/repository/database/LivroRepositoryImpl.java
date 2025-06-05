package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Livro livro) {
        var query = """
                INSERT INTO livro (titulo, autor, ano_publicacao)
                VALUES (:titulo, :autor, :ano_publicacao);
                """;
        entityManager.createNativeQuery(query, Livro.class)
                .setParameter("titulo", livro.getTitulo())
                .setParameter("autor", livro.getAutor())
                .executeUpdate();
    }
    @Transactional
    public void update(int id, Livro livro) {
        var query = """
                UPDATE livro SET 
                titulo = :titulo, autor = :autor, ano_publicacao = :ano_publicacao
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Livro.class)
                .setParameter("titulo", livro.getTitulo())
                .setParameter("autor", livro.getAutor())
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
}
