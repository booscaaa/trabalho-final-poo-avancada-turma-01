package br.com.cesurgmarau.trabalho_final.service.impl;

import br.com.cesurgmarau.trabalho_final.dto.ProdutoDTO;
import br.com.cesurgmarau.trabalho_final.entity.Produto;
import br.com.cesurgmarau.trabalho_final.exception.RecursoNaoEncontradoException;
import br.com.cesurgmarau.trabalho_final.repository.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.service.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        return toDTO(repository.save(produto));
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        return toDTO(repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado")));
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        return toDTO(repository.save(produto));
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        return dto;
    }
}
