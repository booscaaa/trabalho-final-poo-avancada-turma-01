package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> listAllUsers ();
    public User listByID (int id);
    public void createUser (User user);
    public String deleteUser(int id);
    public String updateUser (int id, User user);
}
