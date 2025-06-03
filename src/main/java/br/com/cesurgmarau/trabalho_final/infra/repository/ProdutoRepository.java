package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
