package br.com.cesurgmarau.trabalho_final.core.domain.dto;

public class UsuarioAtivoDto {
    private String nomeUsuario;
    private double totalComentarios;

    public UsuarioAtivoDto(String nomeUsuario, double frequencia){
        this.nomeUsuario = nomeUsuario;
        this.totalComentarios = frequencia;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public double getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(double totalComentarios) {
        this.totalComentarios = totalComentarios;
    }
}
