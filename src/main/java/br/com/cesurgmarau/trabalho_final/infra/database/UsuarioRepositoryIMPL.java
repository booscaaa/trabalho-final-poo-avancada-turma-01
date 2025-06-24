package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryIMPL implements UsuarioRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void cadastraUsuario(Usuario usuario) {
        String query = "INSERT INTO usuario(nome, idade) VALUES(:nome, :idade)";

        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("idade", usuario.getIdade())
                .executeUpdate();

    }

    @Override
    public List<Usuario> listarUsuario() {
        String query = "SELECT * FROM usuario";

        return entityManager.createNativeQuery(query, Usuario.class)
                .getResultList();

    }

    @Override
    public Usuario getId(Long id) {
        String query = "SELECT * FROM usuario WHERE id = :id";

        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Transactional
    @Override
    public void atualizaUsuario(Usuario usuario, Long id) {
        String query = "UPDATE usuario SET (nome, idade) = (:nome, :idade) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("nome", usuario.getNome())
                .setParameter("idade", usuario.getIdade())
                .setParameter("id",id)
                .executeUpdate();

    }

    @Transactional
    @Override
    public void deletaUsuario(Long id) {
        String query = "DELETE FROM usuario WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();

    }
}
