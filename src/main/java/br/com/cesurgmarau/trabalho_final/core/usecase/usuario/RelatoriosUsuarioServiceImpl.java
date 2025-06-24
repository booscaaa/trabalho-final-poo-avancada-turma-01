package br.com.cesurgmarau.trabalho_final.core.usecase.usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosUsuario.RelatoriosUsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosUsuario.RelatoriosUsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.RankingUsuarioOutput.RankingUsuarioOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoriosUsuarioServiceImpl implements RelatoriosUsuarioUseCase {

    @Autowired
    RelatoriosUsuarioRepository relatoriosUsuarioRepository;

    @Override
    public List<RankingUsuarioOutput> rankingAtividadeUsuarios() {
        return relatoriosUsuarioRepository.rankingAtividadeUsuarios();
    }
}
