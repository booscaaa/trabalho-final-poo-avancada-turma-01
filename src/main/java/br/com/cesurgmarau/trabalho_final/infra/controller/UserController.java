package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UserUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    private UserUseCase userUseCase;


    @GetMapping("/product")
    public List<User> listAllUsers() {
        return userUseCase.listAllUsers();
    }

    @GetMapping("/product/{id}")
    public User listByID (@PathVariable int id) {
        return userUseCase.listByID(id);
    }

    @PostMapping("/product")
    public void createUser(@RequestBody User user) {
        userUseCase.createUser(user);
    }

    @DeleteMapping("/product/{id}")
    public String deleteUser (@PathVariable int id) {
        return userUseCase.deleteUser(id);
    }

    @PutMapping("/product/{id}")
    public String updateUser (@PathVariable int id, @RequestBody User user) {
        return userUseCase.updateUser(id, user);
    }
}
