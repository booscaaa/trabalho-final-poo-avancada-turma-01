package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Ranking.RankingRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Ranking.RankingUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RankingUsuariosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingUseCaseImpl implements RankingUseCase {
    @Autowired
    private RankingRepository rankingRepository;


    @Override
    public List<RankingUsuariosDTO> rankingUsuarios() {
        return rankingRepository.rankingUsuarios();
    }
}
