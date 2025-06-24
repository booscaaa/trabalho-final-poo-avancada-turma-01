package br.com.cesurgmarau.trabalho_final.core.dto;

public class UsuarioDestaqueResponse {
    private Integer id;
    private String nome;
    private Long totalComentariosPositivos;

    public UsuarioDestaqueResponse() {
    }

    public UsuarioDestaqueResponse(Integer id, String nome, Long totalComentariosPositivos) {
        this.id = id;
        this.nome = nome;
        this.totalComentariosPositivos = totalComentariosPositivos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTotalComentariosPositivos() {
        return totalComentariosPositivos;
    }

    public void setTotalComentariosPositivos(Long totalComentariosPositivos) {
        this.totalComentariosPositivos = totalComentariosPositivos;
    }
}
