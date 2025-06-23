package br.com.cesurgmarau.trabalho_final.infra.database.repository;


import br.com.cesurgmarau.trabalho_final.core.domain.contract.UserRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public String createUser(User user) {
        var query = "INSERT INTO users (name, email, password) VALUES (:name, :email, :password);";

        entityManager.createNativeQuery(query, User.class)
                .setParameter("name", user.getName())
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .executeUpdate();

        return "usuario criado com sucesso";

    }

    @Override
    public List<User> getAllUser() {
        var query = "SELECT * FROM users;";

        return (List<User>) entityManager.createNativeQuery(query, User.class).getResultList();
    }

    @Override
    public User listUserByID(int id) {
        var query = "SELECT * FROM users WHERE id = :id";

        return (User) entityManager.createNativeQuery(query, User.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Transactional
    @Override
    public String updateUser(int id, User user) {
        var query = "UPDATE users SET (name, email, password) VALUES (:name, :email, :password) WHERE id = :id";

        entityManager.createNativeQuery(query, User.class)
                .setParameter("name", user.getName())
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .setParameter("id", id)
                .executeUpdate();
        return "usuario alterado com sucesso!";
    }

    @Transactional
    @Override
    public String deleteUser(int id) {
        var query = "DELETE FROM users WHERE id = :id";

        entityManager.createNativeQuery(query, User.class).setParameter("id", id).executeUpdate();
        return "usuario deletado com sucesso!";
    }
}
