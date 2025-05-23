package br.com.cesurgmarau.trabalho_final.core.domain.dto;

public record ComentarioDTO(
        int id,
        String texto,
        String sentimento,
        String usuarioNome,
        String usuarioProduto
) {
    public ComentarioDTO(int id, String texto, String sentimento, String usuarioNome, String usuarioProduto) {
        this.id = id;
        this.texto = texto;
        this.sentimento = sentimento;
        this.usuarioNome = usuarioNome;
        this.usuarioProduto = usuarioProduto;
    }
}
