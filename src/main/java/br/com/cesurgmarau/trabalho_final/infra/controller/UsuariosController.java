package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.UsuariosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuariosController {
    @Autowired
    UsuariosUseCase usuariosUseCase;

    @GetMapping("/usuario")
    public ResponseEntity<?> fetch () throws Exception {
        try {
            List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios> Usuarios = usuariosUseCase.fetch();
            return ResponseEntity.ok(Usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os Usuário! " + e.getMessage());
        }

    }

    @GetMapping ("/usuario/{id}")
    public ResponseEntity<?> fetchById (@PathVariable int id) throws Exception {

        try {
            br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios usuarios = usuariosUseCase.fetchById(id);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar Usuario! " + e.getMessage());
        }

    }

    @PostMapping("/usuario")
    public ResponseEntity createUsuario (@RequestBody br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios usuario) throws Exception {

        try {

            usuariosUseCase.createUsuarios(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario adicionado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar o Usuario! " + e.getMessage());
        }

    }

    @PutMapping("usuario/{id}")
    public ResponseEntity updateUsuario (@RequestBody br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios user, @PathVariable int id) throws Exception{

        try {

            usuariosUseCase.updateUsuarios(user, id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Usuário atualizado com sucesso!");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar Usuário " + e.getMessage());

        }

    }

    @DeleteMapping ("usuario/{id}")
    public ResponseEntity deleteUsuario (@PathVariable int id) throws Exception {

        try {

            usuariosUseCase.deleteUsuarios(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Usuário excluído com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir Usuário! " + e.getMessage());
        }

    }
}
