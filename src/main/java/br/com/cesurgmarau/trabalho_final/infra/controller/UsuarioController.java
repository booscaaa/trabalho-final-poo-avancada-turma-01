package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioContracts.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.infra.exceptions.MensagemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    public ResponseEntity<MensagemResponse> adicionarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()){
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
        }

        try {
            usuarioUseCase.adicionarUsuario(usuario);
            return ResponseEntity.ok(new MensagemResponse("Usuário criado com sucesso!"));
        } catch (Exception e){
            throw new RuntimeException("Erro ao criar usuário: " + e.getMessage());
        }
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> listar(){
        try{
            List<Usuario> usuarios = usuarioUseCase.listarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e){
            throw new RuntimeException("Erro ao listar usuários.");
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> usuarioPorId(@PathVariable int id){
        if (id < 1){
            throw new IllegalArgumentException("ID inválido.");
        }

        try{
            Usuario usuario = usuarioUseCase.usuarioPorId(id);

            if (usuario == null) {
                throw new ClassNotFoundException("Usuário não encontrado. Confira as informações.");
            }
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            throw new RuntimeException("Erro ao listar usuário por ID." + e.getMessage());
        }
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemResponse> atualizaUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        if (id < 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        if (usuario.getNome().isBlank() || usuario.getNome() == null) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        try {
            usuarioUseCase.atualizarUsuario(id, usuario);
            return ResponseEntity.ok(new MensagemResponse("Usuario atualizado com sucesso!"));
        } catch (Exception e){
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemResponse> delete(@PathVariable int id){
        if (id < 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        try{
            usuarioUseCase.deletarUsuario(id);
            return ResponseEntity.ok(new MensagemResponse("Usuario deletado com sucesso!"));
        } catch (Exception e){
            throw new RuntimeException("Erro ao deletar usuário" + e.getMessage());
        }
    }
}




