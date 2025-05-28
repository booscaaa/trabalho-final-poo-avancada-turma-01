package br.com.cesurgmarau.trabalho_final.core.dto.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="compra")
public class CompraRepositoryDto {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="data")
    private Date data;

    @Column(name="valorTotal", nullable=false)
    private int valorTotal;

    @Column(name="usuario_id", nullable=false)
    private int usuarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
