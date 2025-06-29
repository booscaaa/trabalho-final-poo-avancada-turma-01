package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
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
    @Override
    public void create(Usuario usuario) {
        var query = """
                INSERT INTO usuario (nome, email, senha)
                VALUES (:nome, :email, :senha);
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Usuario usuario) {
        var query = """
                UPDATE usuario SET 
                nome = :nome, email = :email, senha = :senha
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = "DELETE FROM usuario WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Usuario> fetch() {
        var query = "SELECT * FROM usuario;";
        return entityManager.createNativeQuery(query, Usuario.class).getResultList();
    }

    @Override
    public Usuario fetchById(int id) {
        var query = "SELECT * FROM usuario WHERE id = :id;";
        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
