package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
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
    public void adicionarUsuario(Usuario usuario) {
        var query = """
                INSERT INTO usuario (cpf, nome)
                VALUES (:cpf, :nome)
                """;
            entityManager.createNativeQuery(query)
                    .setParameter("cpf", usuario.getCpf())
                    .setParameter("nome", usuario.getNome())
                    .executeUpdate();
    }

    @Override
    public Usuario listarUsuarioPorId(int id) {
        var query = """
                SELECT * FROM usuario WHERE id = :id;
                """;
        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        var query = """
                SELECT * FROM usuario;
                """;
        return entityManager.createNativeQuery(query, Usuario.class).getResultList();
    }

    @Transactional
    @Override
    public void deletarUsuario(int id) {
        var query = """
                DELETE FROM usuario WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarUsuario(int id, Usuario usuario) {
        var query = """
                UPDATE usuario SET
                nome = :nome,
                cpf = :cpf,
                quantidade_comentario = :quantidade_comentario
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("cpf", usuario.getCpf())
                .setParameter("quantidade_comentario", usuario.getQuantidadeComentario())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void atualizarQuantidadeComentario(int id, int quantidade) {
        var query = """
                UPDATE usuario SET
                quantidade_comentario = quantidade_comentario + :quantidade
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .setParameter("quantidade", quantidade)
                .executeUpdate();
    }
}
