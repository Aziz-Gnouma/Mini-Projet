package net.javaguides.springboot.model;

import jakarta.persistence.*;
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private double prix;

    @Column(name = "quantite")
    private Integer quantite;





    public Produit(String nom, double prix, int quantite) {
        super();
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getprix() {
        return prix;
    }
    public void setprix(double prix) {
        this.prix = prix;
    }
    public Integer getquantite() {
        return quantite;
    }
    public void setquantite(Integer quantite) {
        this.quantite = quantite;
    }
}

