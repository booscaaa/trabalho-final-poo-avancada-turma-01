package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var query = """
            INSERT INTO usuario (nome, email) 
            VALUES (:nome, :email);
        """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        var query = "SELECT * FROM usuario WHERE id = :id";
        List<Usuario> resultado = entityManager
                .createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getResultList();

        return resultado.stream().findFirst();
    }

    @Override
    public List<Usuario> listarTodos() {
        var query = "SELECT * FROM usuario";
        return entityManager.createNativeQuery(query, Usuario.class).getResultList();
    }

    @Override
    @Transactional
    public void atualizar(Integer id, Usuario usuario) {
        var query = """
            UPDATE usuario
            SET nome = :nome,
                email = :email
            WHERE id = :id
        """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        var query = "DELETE FROM usuario WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
