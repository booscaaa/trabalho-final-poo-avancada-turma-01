package br.com.cesurgmarau.trabalho_final.core.usecase.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.CRUD.ProdutoCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.infra.repository.produto.ProdutoCRUDRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCRUDServiceImpl implements ProdutoCRUDUseCase {

    @Autowired
    ProdutoCRUDRepositoryImpl produtoCRUDRepository;


    @Override
    public List<Produto> fetch() {
        return produtoCRUDRepository.fetch();
    }

    @Override
    public Produto fetchById(int id) {
        return produtoCRUDRepository.fetchById(id);
    }

    @Override
    public void createProduto(Produto produto) {
        produtoCRUDRepository.createProduto(produto);
    }

    @Override
    public void updateProduto(Produto produto, int id) {
        produtoCRUDRepository.updateProduto(produto, id);
    }

    @Override
    public void deleteProduto(int id) {
        produtoCRUDRepository.deleteProduto(id);
    }
}
