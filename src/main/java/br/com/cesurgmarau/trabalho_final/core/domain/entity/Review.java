package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "account_id")
    private int accountID;

    @Column(name = "product_id")
    private int productID;

    @Column(name = "classification_id")
    private int classificationID;

    @Column(name = "score_id")
    private int scoreID;

    @Column(name = "comment")
    private String comment;

    @JsonProperty("accountName")
    private String accountName;

    private String product;

    private String classification;

    private String score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getClassificationID() {
        return classificationID;
    }

    public void setClassificationID(int classificationID) {
        this.classificationID = classificationID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
