package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping()
    public void insert(@RequestBody Livro livro) {
        livroRepository.insert(livro);
    }

    @GetMapping()
    public List<Livro> list() {
        return livroRepository.fetch();
    }

    @PostMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Livro livro) {livroRepository.update(id, livro);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        livroRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Livro get(@PathVariable int id) {
        return livroRepository.get(id);
    }
}


