package br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;

import java.util.List;

public interface CompraUseCase {
    void createCompra(Compra compra);
    List<Compra> readCompra();
    Compra readCompra(Integer id);
    void updateCompra(Integer id, Compra compra);
    void deleteCompra(Integer id);
}
