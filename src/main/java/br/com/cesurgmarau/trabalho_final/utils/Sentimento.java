package br.com.cesurgmarau.trabalho_final.utils;

public enum Sentimento {
    MUITO_NEGATIVO("Muito negativo", 1),
    NEGATIVO("Negativo", 2),
    NEUTRO("Neutro", 3),
    POSITIVO("Positivo", 4),
    MUITO_POSITIVO("Muito positivo", 5);

    private final String descricao;
    private final int valor;

    Sentimento(String descricao, int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public static Sentimento fromDescricao(String descricao) {
        for (Sentimento s : Sentimento.values()) {
            if (s.getDescricao().equalsIgnoreCase(descricao)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sentimento inválido: " + descricao);
    }
}
