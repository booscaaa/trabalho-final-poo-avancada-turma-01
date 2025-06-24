package br.com.cesurgmarau.trabalho_final.service.impl;

import br.com.cesurgmarau.trabalho_final.dto.UsuarioDTO;
import br.com.cesurgmarau.trabalho_final.dto.UsuarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.exception.RecursoNaoEncontradoException;
import br.com.cesurgmarau.trabalho_final.repository.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioDTO salvar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return toDTO(repository.save(usuario));
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        return toDTO(repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado")));
    }

    @Override
    public List<UsuarioDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return toDTO(repository.save(usuario));
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deletar(Long id) {

    }

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }
}
