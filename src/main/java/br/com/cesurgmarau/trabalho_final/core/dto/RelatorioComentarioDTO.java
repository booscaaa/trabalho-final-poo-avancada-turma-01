package br.com.cesurgmarau.trabalho_final.core.dto;

public class RelatorioComentarioDTO {
    private String sentimento;
    private int nota;
    private long total;

    public RelatorioComentarioDTO(String sentimento, int nota, long total) {
        this.sentimento = sentimento;
        this.nota = nota;
        this.total = total;
    }

    public String getSentimento() {
        return sentimento;
    }

    public int getNota() {
        return nota;
    }

    public long getTotal() {
        return total;
    }
}
