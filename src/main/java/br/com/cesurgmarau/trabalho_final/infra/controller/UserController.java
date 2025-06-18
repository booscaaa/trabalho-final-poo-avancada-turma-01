
package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UserUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserUseCase userUseCase;

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        userUseCase.createUser(user);
        return "usuario criado com sucesso!";
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        userUseCase.updateUser(id, user);
        return "usuario alterado com sucesso!";
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        List<User> user = userUseCase.getAllUser();
        return user;
    }

    @GetMapping("/user/{id}")
    public User listUserByID(@PathVariable int id) {
        return userUseCase.listUserByID(id);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return userUseCase.deleteUser(id);
    }
}

