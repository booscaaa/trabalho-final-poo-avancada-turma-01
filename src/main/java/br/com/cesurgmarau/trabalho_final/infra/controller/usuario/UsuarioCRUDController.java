package br.com.cesurgmarau.trabalho_final.infra.controller.usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.CRUD.ProdutoCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.CRUD.UsuarioCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioCRUDController {

    @Autowired
    UsuarioCRUDUseCase usuarioCRUDUseCase;

    @GetMapping("/usuarios")
    public ResponseEntity<?> fetch () throws Exception {
        try {
            List<Usuario> usuarios = usuarioCRUDUseCase.fetch();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os usuarios! " + e.getMessage());
        }

    }

    @GetMapping ("/usuario/{id}")
    public ResponseEntity<?> fetchById (@PathVariable int id) throws Exception {

        try {
            Usuario usuario = usuarioCRUDUseCase.fetchById(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar usuario! " + e.getMessage());
        }

    }

    @PostMapping("/usuarios")
    public ResponseEntity createUsuario (@RequestBody Usuario usuario) throws Exception {

        try {

            usuarioCRUDUseCase.createUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario adicionado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar o usuario! " + e.getMessage());
        }

    }

    @PutMapping ("/usuario/{id}")
    public ResponseEntity updateUsuario (@RequestBody Usuario usuario, @PathVariable int id) throws Exception{

        try {

            usuarioCRUDUseCase.updateUsuario(usuario, id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Usuario atualizado com sucesso!");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar usuario " + e.getMessage());

        }

    }

    @DeleteMapping ("/usuario/{id}")
    public ResponseEntity deleteUsuario (@PathVariable int id) throws Exception {

        try {

            usuarioCRUDUseCase.deleteUsuario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Usuario excluído com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir usuario! " + e.getMessage());
        }

    }

}
