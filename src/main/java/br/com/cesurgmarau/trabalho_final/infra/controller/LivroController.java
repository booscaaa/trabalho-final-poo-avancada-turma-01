package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("/livro")
    public void insert(@RequestBody Livro livro) {
        livroRepository.insert(livro);
    }

    @GetMapping("/livro")
    public List<Livro> list() {
        return livroRepository.fetch();
    }

    @PostMapping("/livro/id")
    public void update(@PathVariable int id, @RequestBody Livro livro) {livroRepository.update(id, livro);
    }
    @DeleteMapping("/livro/{id}")
    public void delete(@PathVariable int id) {
        livroRepository.delete(id);
    }

    @GetMapping("/livro/{id}")
    public void get(@PathVariable int id) {
        livroRepository.get(id);
    }
}


