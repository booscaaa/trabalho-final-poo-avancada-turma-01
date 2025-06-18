package br.com.cesurgmarau.trabalho_final.core.UseCase.impl;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UserRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UserUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCaseImpl implements UserUseCase {
    @Autowired
    private UserRepository repository;
    private User user;


    @Override
    public String createUser(User user) {
        return repository.createUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return repository.getAllUser();

    }

    @Override
    public User listUserByID(int id) {
        return repository.listUserByID(id);
    }

    @Override
    public String updateUser(int id, User user) {
        return repository.updateUser(id, user);
    }

    @Override
    public String deleteUser(int id) {
        return repository.deleteUser(id);
    }
}
