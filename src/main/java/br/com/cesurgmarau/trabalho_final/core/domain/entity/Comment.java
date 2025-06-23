package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "comments")
public class Comment {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "feeling_id")
    private int feeling_id;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "user_id")
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFeeling_id() {
        return feeling_id;
    }

    public void setFeeling_id(int feeling_id) {
        this.feeling_id = feeling_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
