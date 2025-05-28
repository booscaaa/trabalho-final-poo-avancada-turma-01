package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
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
    public void usuarioPorId(int id, Usuario usuario) {

    }

    @Override
    public void atualizarUsuario(int id, Usuario usuario) {

    }

    @Override
    public void deletarUsuario(int id) {

    }
}
