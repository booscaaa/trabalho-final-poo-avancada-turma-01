package br.com.cesurgmarau.trabalho_final.Controller;


import br.com.cesurgmarau.trabalho_final.Dto.UserDTO;
import br.com.cesurgmarau.trabalho_final.Entity.User;
import br.com.cesurgmarau.trabalho_final.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<User> listUsers = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsers);
    }
}
