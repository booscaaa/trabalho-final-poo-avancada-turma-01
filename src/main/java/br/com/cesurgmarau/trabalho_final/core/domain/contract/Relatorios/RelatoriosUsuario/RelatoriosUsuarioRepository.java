package br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosUsuario;

import br.com.cesurgmarau.trabalho_final.core.dto.RankingUsuarioOutput.RankingUsuarioOutput;

import java.util.List;

public interface RelatoriosUsuarioRepository {

    List<RankingUsuarioOutput> rankingAtividadeUsuarios ();

}
