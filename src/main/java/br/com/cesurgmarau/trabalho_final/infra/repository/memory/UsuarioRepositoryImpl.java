package br.com.cesurgmarau.trabalho_final.infra.repository.memory;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarUsuario(Usuario usuario) {
        var query = """
                INSERT INTO usuarios (id, nome, email)
                VALUES (:id, :nome, :email)
                """;

        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", usuario.getId())
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarUsuario(int id, Usuario usuario) {
        var query = """
                UPDATE usuarios SET
                nome = :nome,
                email = :email
                WHERE id = :id
                """;

        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .setParameter("id", id)
                .executeUpdate();

        return "Usuário atualizado com sucesso!";
    }

    @Transactional
    @Override
    public String deletarUsuario(int id) {
        var query = "DELETE FROM usuarios WHERE id = :id";

        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .executeUpdate();

        return "Usuário removido com sucesso!";
    }

    @Override
    public List<Usuario> listar() {
        var query = "SELECT * FROM usuarios";

        return (List<Usuario>) entityManager
                .createNativeQuery(query, Usuario.class)
                .getResultList();
    }

    @Override
    public Usuario listarPorId(int id) {
        var query = "SELECT * FROM usuarios WHERE id = :id";

        return (Usuario) entityManager
                .createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}

