package br.com.cesurgmarau.trabalho_final.infra.repository.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.CRUD.ProdutoCRUDRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoCRUDRepositoryImpl implements ProdutoCRUDRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Produto> fetch() {
        var query = """
                
                SELECT * FROM produtos;
                
                
                """;
        return (List<Produto>) entityManager.createNativeQuery(query, Produto.class).getResultList();

    }

    @Override
    public Produto fetchById(int id) {

        var query = """
                
                SELECT * FROM produtos where id = :id
                
                """;


        return (Produto) entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createProduto(Produto produto) {

        var query = """
                
                INSERT INTO produtos (nome, preco, descricao)
                VALUES (:nome, :preco, :descricao);
                
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("preco", produto.getPreco())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();

        System.out.println("Produto adicionado com sucesso!");

    }

    @Transactional
    @Override
    public void updateProduto(Produto produto, int id) {

        var query = """
                
                UPDATE FROM produtos SET
                nome = :nome
                preco = :preco
                descricao = :descricao
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("preco", produto.getPreco())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();

        System.out.println("Produto atualizado com sucesso!");

    }

    @Transactional
    @Override
    public void deleteProduto(int id) {

        var query = """
                
                DELETE FROM produtos WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Produto excluído com sucesso!");

    }
}
