package br.com.cesurgmarau.trabalho_final.UseCase;

import br.com.cesurgmarau.trabalho_final.Dto.UserDTO;
import br.com.cesurgmarau.trabalho_final.Entity.User;
import br.com.cesurgmarau.trabalho_final.Repository.UserRepository;

public class UserUseCase {

    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setId(userDTO.id());
        return userRepository.save(user);
    }

}
