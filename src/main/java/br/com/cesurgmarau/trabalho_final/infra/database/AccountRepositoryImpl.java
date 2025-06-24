package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.AccountRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Account create(Account account) {
        var query = """
            INSERT INTO account(username, name)
            VALUES (:username, :name)
            RETURNING id;
            """;

        var id = (Number) entityManager.createNativeQuery(query)
                .setParameter("username", account.getUsername())
                .setParameter("name", account.getName())
                .getSingleResult();

        account.setId(id.intValue());
        return account;
    }

    @Transactional
    @Override
    public Account update(int accountID, Account account) {
        var query = """
                UPDATE account SET
                username = :username,
                name = :name
                WHERE id = :id
                """;

        int rowsAffected = entityManager.createNativeQuery(query, Account.class)
                .setParameter("username", account.getUsername())
                .setParameter("name", account.getName())
                .setParameter("id", accountID)
                .executeUpdate();

        if (rowsAffected == 0) {
            throw new RuntimeException("Account not found with id: " + accountID);
        }

        account.setId(accountID);
        return account;
    }

    @Transactional
    @Override
    public void delete(int accountID) {
        var query = "DELETE FROM account WHERE id = :id;";
        entityManager.createNativeQuery(query, Account.class)
            .setParameter("id", accountID)
            .executeUpdate();
    }

    @Override
    public Account getByID(int accountID) {
        var query = "SELECT * FROM account WHERE id = :id;";

        return (Account) entityManager.createNativeQuery(query, Account.class)
                .setParameter("id", accountID)
                .getSingleResult();
    }

    @Override
    public List<Account> fetch() {
        var query = "SELECT * FROM account;";

        return entityManager.createNativeQuery(query, Account.class).getResultList();
    }

}
