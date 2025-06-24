package br.com.cesurgmarau.trabalho_final.core.dto.comentario;

public class ComentarioResponseDTO {
    private int id;
    private String descricao;
    private int sentimento_id;
    private int usuario_id;
    private int produto_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSentimento_id() {
        return sentimento_id;
    }

    public void setSentimento_id(int sentimento_id) {
        this.sentimento_id = sentimento_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }
}
