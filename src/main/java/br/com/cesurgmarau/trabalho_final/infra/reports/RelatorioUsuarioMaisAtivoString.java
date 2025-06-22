package br.com.cesurgmarau.trabalho_final.infra.reports;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioUsuarioMaisAtivo;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class RelatorioUsuarioMaisAtivoString implements RelatorioUsuarioMaisAtivo {
    @Override
    public String relatorioUsuarioMaisAtivo(List<Usuario> usuarioList) {
        List<String> relatoriosSeparados = usuarioList.stream().map(usuario -> usuario.getNome() + " : " + usuario.getQuantidadeComentario() + " comentários.").collect(Collectors.toList());

        return String.join("\n", relatoriosSeparados );
    }
}
