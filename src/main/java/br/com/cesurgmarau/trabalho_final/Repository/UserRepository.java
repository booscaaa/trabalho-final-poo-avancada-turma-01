package br.com.cesurgmarau.trabalho_final.Repository;

import br.com.cesurgmarau.trabalho_final.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
