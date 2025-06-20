package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioContracts.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioContracts.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.MediaProdutoDto;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.UsuarioAtivoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RelatorioUseCaseImpl implements RelatorioUseCase {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public RelatorioUseCaseImpl(RelatorioRepository relatorioRepository){
        this.relatorioRepository = relatorioRepository;
    }

    @Override
    public List<Objects[]> relatorioSentimentos() {
        return this.relatorioRepository.relatorioSentimentos();
    }

    @Override
    public List<MediaProdutoDto> mediaProdutos() {
        return this.relatorioRepository.mediaProdutos().stream()
                .map(obj -> new MediaProdutoDto(
                        (String) obj[0],
                        ((Number) obj[1]).doubleValue()
                )).toList();
    }

    @Override
    public List<UsuarioAtivoDto> usuarioMaisAtivo() {
        return this.relatorioRepository.usuarioMaisAtivo().stream()
                .map(obj -> new UsuarioAtivoDto(
                        (String) obj[0],
                        ((Number) obj[1]).doubleValue()
                )).toList();
    }
}
