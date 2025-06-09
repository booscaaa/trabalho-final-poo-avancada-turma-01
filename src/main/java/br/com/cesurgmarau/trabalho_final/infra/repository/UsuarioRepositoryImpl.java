package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository.UsuariosRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class UsuarioRepositoryImpl implements UsuariosRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios> fetch() {
        var query = """
                
                SELECT * FROM usuarios;
                
                
                """;
        return (List<Usuarios>) entityManager.createNativeQuery(query, Usuarios.class).getResultList();

    }

    @Override
    public Usuarios fetchById(int id) {

        var query = """
                
                SELECT * FROM usuarios where id = :id
                
                """;


        return (Usuarios) entityManager.createNativeQuery(query, Usuarios.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createUsuarios(Usuarios users) {

        var query = """
                
                INSERT INTO usuarios (nome, email)
                VALUES (:nome, :email);
                
                """;

        entityManager.createNativeQuery(query, Usuarios.class)

                .setParameter("nome", users.getName())
                .setParameter("email", users.getEmail())
                .executeUpdate();

        System.out.println("Usuario postado com sucesso!");

    }

    @Transactional
    @Override
    public void updateUsuarios(Usuarios user, int id) {

        var query = """
                
                UPDATE FROM comentarios SET
                nome = :nome
                email = :email
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Usuarios.class)
                .setParameter("nome", user.getName())
                .setParameter("email", user.getName())
                .executeUpdate();

        System.out.println("Usuario atualizado com sucesso!");

    }

    @Transactional
    @Override
    public void deleteUsuarios(int id) {

        var query = """
                
                DELETE FROM usuarios WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Usuarios.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Usário excluído com sucesso!");

    }

}
