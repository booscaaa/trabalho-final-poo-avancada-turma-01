package br.com.cesurgmarau.trabalho_final.Repository;

import br.com.cesurgmarau.trabalho_final.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    private final UserRepository userRepository;
    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
