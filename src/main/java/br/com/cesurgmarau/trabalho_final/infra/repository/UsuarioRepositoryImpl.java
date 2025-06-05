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

    @Transactional
    public void update(int id, Usuario usuario) {
        var query = """
                UPDATE usuario SET nome = :nome, email = :email
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();

    }

    @Transactional
    public void delete(int id) {
        var query = """
                DELETE FROM usuario WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Usuario> fetch() {
        var query = """
                SELECT id, nome, email FROM usuario;
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .getResultList();
    }

    public Usuario get(int id) {
        return null;
    }
}
