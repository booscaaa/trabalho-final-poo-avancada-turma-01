package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Ranking.RankingRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RankingUsuariosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {
    @Autowired
    private RankingRepository rankingRepository;

    @GetMapping("/ranking/usuarios")
    public List<RankingUsuariosDTO> rankingUsuarios() {
        return rankingRepository.rankingUsuarios();
    }
}
