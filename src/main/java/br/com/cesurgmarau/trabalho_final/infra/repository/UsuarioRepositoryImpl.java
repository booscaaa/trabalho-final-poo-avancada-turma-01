package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioContracts.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void adicionarUsuario(Usuario usuario) {
        var query = """
                INSERT INTO usuarios (nome, idade)
                VALUES(:nome, :idade)
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("idade", usuario.getIdade())
                .executeUpdate();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        var query = "SELECT * FROM usuarios";

        return (List<Usuario>) entityManager.createNativeQuery(query, Usuario.class).getResultList();
    }

    @Override
    public Usuario usuarioPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void atualizarUsuario(int id, Usuario usuario) {
        var query = """
                    UPDATE usuarios
                    SET nome = :nome, idade = :idade
                    WHERE id_usuario = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("idade", usuario.getIdade())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void deletarUsuario(int id) {
        var query = """
                    DELETE FROM usuarios WHERE id_usuario = :id
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
