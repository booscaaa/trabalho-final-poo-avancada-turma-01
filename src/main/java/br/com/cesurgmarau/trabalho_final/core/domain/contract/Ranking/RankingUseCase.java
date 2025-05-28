package br.com.cesurgmarau.trabalho_final.core.domain.contract.Ranking;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.RankingProdutosDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RankingUsuariosDTO;

import java.util.List;

public interface RankingUseCase {
    public List<RankingUsuariosDTO> rankingUsuarios();
    public List<RankingProdutosDTO> rankingProdutos();
}
