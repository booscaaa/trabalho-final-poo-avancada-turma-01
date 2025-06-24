package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Score;

import java.util.List;

public interface ScoreRepository {
    public List<Score> fetch();
    public Score getByName(String name);
}
