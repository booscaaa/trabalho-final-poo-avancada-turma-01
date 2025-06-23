package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;

import java.util.List;

public interface UserRepository {
    public String createUser(User user);

    public List<User> getAllUser();

    public User listUserByID(int id);

    public String updateUser(int id, User user);

    public String deleteUser(int id);
}
