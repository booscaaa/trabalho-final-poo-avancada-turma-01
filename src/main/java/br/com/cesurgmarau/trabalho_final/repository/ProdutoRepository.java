package br.com.cesurgmarau.trabalho_final.repository;

import br.com.cesurgmarau.trabalho_final.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}