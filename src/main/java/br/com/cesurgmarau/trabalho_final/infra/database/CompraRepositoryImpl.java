package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.CompraRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompraRepositoryImpl implements CompraRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void createCompra(Compra compra) {
        String query = "INSERT INTO compra (valor_total, usuario_id) VALUES (:valor_total, :usuario_id)";

        entityManager.createNativeQuery(query)
                .setParameter("valor_total", compra.getValorTotal())
                .setParameter("usuario_id", compra.getUsuario().getId())
                .executeUpdate();
    }

    @Override
    public List<Compra> readCompra() {
        String query = "SELECT * FROM compra";

        return entityManager.createNativeQuery(query, Compra.class)
                .getResultList();
    }

    @Override
    public Compra readCompra(Integer id) {
        String query = "SELECT * FROM compra WHERE id = :id";

        return (Compra) entityManager.createNativeQuery(query, Compra.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void updateCompra(Integer id, Compra compra) {
        String query = "UPDATE compra SET (valor_total, usuario_id) = (:valor_total, :usuario_id) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("valor_total", compra.getValorTotal())
                .setParameter("usuario_id", compra.getUsuario().getId())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteCompra(Integer id) {
        String query = "DELETE FROM compra WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
