package br.com.cesurgmarau.trabalho_final.repository;

import br.com.cesurgmarau.trabalho_final.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}