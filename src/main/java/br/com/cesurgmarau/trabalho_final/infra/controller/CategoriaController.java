package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CategoriaUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaUseCase categoriaUseCase;

    @PostMapping("/categoria")
    public void criarCategoria(@RequestBody Categoria categoria){
        categoriaUseCase.adicionarCategoria(categoria);
    }

    @GetMapping("/categoria")
    public List<Categoria> listarCategoria(){
        return categoriaUseCase.listarCategoria();
    }

    @DeleteMapping("/categoria/{id}")
    public void deletarCategoria (@PathVariable int id){
        categoriaUseCase.deletarCategoria(id);
    }

    @PutMapping("/categoria/{id}")
    public void atualizarCategoria(@PathVariable int id, @RequestBody Categoria categoria){
        categoriaUseCase.atualizarCategoria(id, categoria);
    }
}
