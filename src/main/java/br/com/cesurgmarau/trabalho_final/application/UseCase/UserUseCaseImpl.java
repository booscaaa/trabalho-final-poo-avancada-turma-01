package br.com.cesurgmarau.trabalho_final.application.UseCase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UserUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCaseImpl implements UserUseCase {
    @Override
    public List<User> listAllUsers() {
        return List.of();
    }

    @Override
    public User listByID(int id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public String deleteUser(int id) {
        return "";
    }

    @Override
    public String updateUser(int id, User user) {
        return "";
    }
}
