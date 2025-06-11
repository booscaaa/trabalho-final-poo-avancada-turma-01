package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface QuickSortUsuario {
    public void quickSort (List<Usuario> usuarios, int inicio, int fim);
}
