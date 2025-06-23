package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager.find(Usuario.class, id));
    }

    @Override
    public List<Usuario> buscarTodos() {
        return List.of();
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            entityManager.persist(usuario);
            return usuario;
        } else {
            return entityManager.merge(usuario);
        }
    }
}

