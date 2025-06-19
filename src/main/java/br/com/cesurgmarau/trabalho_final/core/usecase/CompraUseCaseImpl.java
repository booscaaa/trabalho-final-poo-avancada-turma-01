package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.CompraRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.CompraUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraUseCaseImpl implements CompraUseCase {

    @Autowired
    CompraRepository compraRepository;

    @Override
    public void createCompra(Compra compra) {
        compraRepository.createCompra(compra);
    }

    @Override
    public List<Compra> readCompra() {
        return compraRepository.readCompra();
    }

    @Override
    public Compra readCompra(Integer id) {
        return compraRepository.readCompra(id);
    }

    @Override
    public void updateCompra(Integer id, Compra compra) {
        compraRepository.updateCompra(id, compra);
    }

    @Override
    public void deleteCompra(Integer id) {
        compraRepository.deleteCompra(id);
    }
}
