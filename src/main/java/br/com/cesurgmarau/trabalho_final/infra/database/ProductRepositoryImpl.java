package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Product create(Product product) {
        var query = """
                INSERT INTO product(name, price, description)
                VALUES (:name, :price, :description)
                RETURNING id;
                """;

        var id = (Number) entityManager.createNativeQuery(query)
                .setParameter("name", product.getName())
                .setParameter("price", product.getPrice())
                .setParameter("description", product.getDescription())
                .getSingleResult();

        product.setId(id.intValue());
        return product;
    }

    @Transactional
    @Override
    public Product update(int productID, Product product) {
        var query = """
                UPDATE product SET
                name = :name,
                price = :price,
                description = :description
                WHERE id = :id
                """;

        var rowsAffected = entityManager.createNativeQuery(query, Product.class)
                .setParameter("name", product.getName())
                .setParameter("price", product.getPrice())
                .setParameter("description", product.getDescription())
                .setParameter("id", productID)
                .executeUpdate();

        if (rowsAffected == 0) {
            throw new RuntimeException("Product not found with id: " + productID);
        }

        product.setId(productID);
        return product;
    }

    @Transactional
    @Override
    public void delete(int productID) {
        var query = "DELETE FROM product WHERE id = :id;";
        entityManager.createNativeQuery(query, Product.class)
                .setParameter("id", productID)
                .executeUpdate();
    }

    @Override
    public Product getByID(int productID) {
        var query = "SELECT * FROM product WHERE id = :id;";

        return (Product) entityManager.createNativeQuery(query, Product.class)
                .setParameter("id", productID)
                .getSingleResult();
    }

    @Override
    public List<Product> fetch() {
        var query = "SELECT * FROM product;";

        return entityManager.createNativeQuery(query, Product.class).getResultList();
    }

}
