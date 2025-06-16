package br.com.cesurgmarau.trabalho_final.core.dto;

public class RelatorioUsuarioResponse {
    private Integer usuarioId;
    private Long quantidadeComentarios;

    public RelatorioUsuarioResponse(Integer usuarioId, Long quantidadeComentarios) {
        this.usuarioId = usuarioId;
        this.quantidadeComentarios = quantidadeComentarios;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public Long getQuantidadeComentarios() {
        return quantidadeComentarios;
    }
}
