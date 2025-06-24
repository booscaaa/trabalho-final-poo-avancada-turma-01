package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.UsuarioRepository;
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
    public void createUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario (nome, senha, email) VALUES (:nome, :senha, :email)";

        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("senha", usuario.getSenha())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();
    }

    @Override
    public List<Usuario> readUsuario() {
        String query = "SELECT * FROM usuario";

        return entityManager.createNativeQuery(query, Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario readUsuario(Integer id) {
        String query = "SELECT * FROM usuario WHERE id = :id";
        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void updateUsuario(Integer id, Usuario usuario) {
        String query = "UPDATE usuario SET (nome, senha, email) = (:nome, :senha, :email) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("senha", usuario.getSenha())
                .setParameter("email", usuario.getEmail())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteUsuario(Integer id) {
        String query = "DELETE FROM usuario WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
