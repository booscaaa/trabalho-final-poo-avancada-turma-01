package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insert(Usuario usuario) {
        var query = """
                INSERT INTO usuario (nome, email) 
                VALUES (:nome, :email); 
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();
    }
    @Override
    @Transactional
    public void update(int id, Usuario usuario) {
        var query = """
                UPDATE usuario SET nome = :nome, email = :email
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();

    }
    @Override
    @Transactional
    public void delete(int id) {
        var query = """
                DELETE FROM usuario WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
    @Override
    public List fetch() {
        var query = """
                SELECT id, nome, email FROM usuario;
                """;
        return entityManager.createNativeQuery(query, Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario get(int id) {
        var query = """
                SELECT id, nome, email FROM usuario WHERE id = :id;
            """;
        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
