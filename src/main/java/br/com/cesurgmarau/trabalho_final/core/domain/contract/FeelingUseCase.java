package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Feeling;

import java.util.Optional;

public interface FeelingUseCase {
    public int analyzeSentiment(String text);
    Optional<Feeling> findByNameIgnoreCase(String name);
}
