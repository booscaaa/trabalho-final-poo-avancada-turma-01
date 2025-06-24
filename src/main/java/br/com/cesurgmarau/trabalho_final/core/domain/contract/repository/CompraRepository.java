package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;

import java.util.List;

public interface CompraRepository {
    void createCompra(Compra compra);
    List<Compra> readCompra();
    Compra readCompra(Integer id);
    void updateCompra(Integer id, Compra compra);
    void deleteCompra(Integer id);
}
