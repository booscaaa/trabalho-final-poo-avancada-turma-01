package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository.ProdutosRepository;
import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Produtos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutosRepositoryImpl implements ProdutosRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Produtos> fetch() {
        var query = """
                
                SELECT * FROM produtos;
                
                
                """;
        return (List<Produtos>) entityManager.createNativeQuery(query, Produtos.class).getResultList();

    }

    @Override
    public Produtos fetchById(int id) {

        var query = """
                
                SELECT * FROM produtos where id = :id
                
                """;


        return (Produtos) entityManager.createNativeQuery(query, Produtos.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createProduto(Produtos produto) {

        var query = """
                
                INSERT INTO produtos (name, price, descricao)
                VALUES (:name, :price, :descricao, );
                
                """;

        entityManager.createNativeQuery(query, Produtos.class)
                .setParameter("name", produto.getName())
                .setParameter("price", produto.getPrice())
                .setParameter("descricao", produto.getDescricao())
                .executeUpdate();

        System.out.println("Produto adicionado com sucesso!");

    }

    @Transactional
    @Override
    public void updateProduto(Produtos produto, int id) {

        var query = """
                
                UPDATE produtos SET
                name = :name,
                price = :price,
                descricao = :descricao
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Produtos.class)
                .setParameter("name", produto.getName())
                .setParameter("price", produto.getPrice())
                .setParameter("descricao", produto.getDescricao())
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Produto atualizado com sucesso!");

    }

    @Transactional
    @Override
    public void deleteProduto(int id) {

        var query = """
                
                DELETE FROM produtos WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Produtos.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Produto excluído com sucesso!");

    }
}
