package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoContracts.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.infra.exceptions.MensagemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired

    private ProdutoUseCase produtoUseCase;

    @PostMapping("/produto")
    public ResponseEntity<MensagemResponse> adicionaProduto(Produto produto) {
        if (produto.getNome().isBlank() || produto.getNome() == null) {
            throw new IllegalArgumentException("Nome do usuário deve ser preenchido.");
        }

        if (produto.getPreco() == null) {
            throw new IllegalArgumentException("Preço do produto deve ser maior que 0.");
        }

        try {
            this.produtoUseCase.adicionarProduto(produto);
            System.out.println("preco recebido" + produto.getPreco() + produto.getNome());
            return ResponseEntity.ok(new MensagemResponse("Produto adicionado!"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar produto" + e.getMessage());
        }
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> listaProdutos() {
        try {
            List<Produto> produtos = produtoUseCase.listarProdutos();
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar produtos.");
        }
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<?> produtoPorID(@PathVariable int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID inválido;");
        }

        try {
            Produto produto = produtoUseCase.produtoPorID(id);

            if (produto == null) {
                throw new ClassNotFoundException("Produto não encontrado.");
            }
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao retornar produto." + e.getMessage());
        }
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<MensagemResponse> atualizaProduto(@PathVariable int id, @RequestBody Produto produto) {
        if (id < 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        try {
            this.produtoUseCase.atualizarProduto(id, produto);
            return ResponseEntity.ok(new MensagemResponse("Produto atualizado com sucesso!"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atulizar produto." + e.getMessage());
        }
    }

    @DeleteMapping("produto/{id}")
    public ResponseEntity<MensagemResponse> deletaProduto(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        try {
            this.produtoUseCase.deletarProduto(id);
            return ResponseEntity.ok(new MensagemResponse("Produto deletado."));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar produto." + e.getMessage());
        }
    }
}
