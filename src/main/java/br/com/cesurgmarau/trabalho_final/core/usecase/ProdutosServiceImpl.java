package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.ProdutosUseCase;
import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Produtos;
import br.com.cesurgmarau.trabalho_final.infra.repository.ProdutosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosUseCase {
    @Autowired
    ProdutosRepositoryImpl produtosRepository;


    @Override
    public List<Produtos> fetch() {
        return produtosRepository.fetch();
    }

    @Override
    public Produtos fetchById(int id) {
        return produtosRepository.fetchById(id);
    }

    @Override
    public void createProduto(Produtos produto) {
        produtosRepository.createProduto(produto);
    }

    @Override
    public void updateProduto(Produtos produto, int id) {
        produtosRepository.updateProduto(produto, id);
    }

    @Override
    public void deleteProduto(int id) {
        produtosRepository.deleteProduto(id);
    }
}
