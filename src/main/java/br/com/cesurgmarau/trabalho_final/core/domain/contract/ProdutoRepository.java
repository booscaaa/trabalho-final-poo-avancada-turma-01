package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.List;

public interface ProdutoRepository {

    public List<Produto>listar();
    public Produto listarPorId(int id);
    public void adicionarProduto(Produto produto);
    public String deletarProduto(int id);
    public String atualizarProduto(int id, Produto produto);
}
