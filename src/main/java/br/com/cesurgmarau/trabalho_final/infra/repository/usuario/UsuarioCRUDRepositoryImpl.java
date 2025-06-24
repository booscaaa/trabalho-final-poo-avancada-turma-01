package br.com.cesurgmarau.trabalho_final.infra.repository.usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.CRUD.UsuarioCRUDRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UsuarioCRUDRepositoryImpl implements UsuarioCRUDRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> fetch() {
        var query = """
                
                SELECT * FROM usuarios;
                
                
                """;
        return (List<Usuario>) entityManager.createNativeQuery(query, Usuario.class).getResultList();

    }

    @Override
    public Usuario fetchById(int id) {

        var query = """
                
                SELECT * FROM usuarios where id = :id
                
                """;


        return (Usuario) entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createUsuario(Usuario usuario) {

        var query = """
                
                INSERT INTO usuarios (nome, email)
                VALUES (:nome, :email);
                
                """;

        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();

        System.out.println("Usuario adicionado com sucesso!");

    }

    @Transactional
    @Override
    public void updateUsuario(Usuario usuario, int id) {

        var query = """
                
                UPDATE FROM usuarios SET
                nome = :nome
                email = :email
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("nome", usuario.getNome())
                .setParameter("email", usuario.getEmail())
                .executeUpdate();

        System.out.println("Usuario atualizado com sucesso!");

    }

    @Transactional
    @Override
    public void deleteUsuario(int id) {

        var query = """
                
                DELETE FROM usuarios WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Usuario excluído com sucesso!");

    }


}
