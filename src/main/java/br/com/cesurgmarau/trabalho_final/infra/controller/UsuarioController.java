package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.infra.exceptions.MensagemResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    public void adicionarUsuario(@RequestBody Usuario usuario, HttpServletResponse response) {
        try {
            if (usuario.getNome() == null || usuario.getNome().isBlank()){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Todos os campos devem ser preenchidos.");
                return;
            }
            usuarioUseCase.adicionarUsuario(usuario);
            response.setStatus(HttpServletResponse.SC_OK); // 201
            response.getWriter().write("Usuario criado com sucesso");
            //ResponseEntity.status(HttpStatus.OK).body("Usuário criado");
        } catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + e.getMessage());
        }
    }

    @GetMapping("/usuarios")
    public List<Usuario> listar(HttpServletResponse response){
        try{
            return usuarioUseCase.listarUsuarios();
        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return new ArrayList<>();
    }

    @GetMapping("/usuario/{id}")
    public Usuario usuarioPorId(@PathVariable int id, HttpServletResponse response){
        try{
            if (id < 1){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("ID inválido");
            }
            return usuarioUseCase.usuarioPorId(id);

        } catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try{
                response.getWriter().write("Erro ao listar usuario pelo id.");
            } catch (IOException exception){
                exception.printStackTrace();
            }
        }
        return null;

    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<MensagemResponse> atualizaUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        try {
            usuarioUseCase.atualizarUsuario(id, usuario);
            return ResponseEntity.ok(new MensagemResponse("Usuario atualizado com sucesso"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MensagemResponse("Erro ao atualizar usuario: " + e.getMessage() ) );
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<MensagemResponse> delete(@PathVariable int id){
        try{
            usuarioUseCase.deletarUsuario(id);
            return ResponseEntity.ok(new MensagemResponse("Usuario deletado com sucesso"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemResponse("Erro ao deletar usuario: " + e.getMessage()));
        }
    }
}




