package br.com.cesurgmarau.trabalho_final.infra.sorts;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.QuickSortUsuario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuickSortUsuarioImpl implements QuickSortUsuario {

    @Override
    public void quickSort(List<Usuario> usuarios, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = partition(usuarios, inicio, fim);
            quickSort(usuarios, inicio, posicaoPivo - 1);
            quickSort(usuarios, posicaoPivo + 1, fim);
        }
    }

    private static int partition(List<Usuario> usuarios, int inicio, int fim) {
        Usuario pivo = usuarios.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (usuarios.get(j).getQuantidadeComentario() >= pivo.getQuantidadeComentario()) {
                i++;
                trocar(usuarios, i, j);
            }
        }

        trocar(usuarios, i + 1, fim);
        return i + 1;
    }

    private static void trocar(List<Usuario> usuarios, int i, int j) {
        Usuario temp = usuarios.get(i);
        usuarios.set(i, usuarios.get(j));
        usuarios.set(j, temp);
    }
}
