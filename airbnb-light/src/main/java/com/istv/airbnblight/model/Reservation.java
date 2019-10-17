package com.istv.airbnblight.model;


import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loueur")
    private Utilisateur loueur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proprietaire")
    private Utilisateur proprietaire;

    private long de;

    private long a;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getLoueur() {
        return loueur;
    }

    public void setLoueur(Utilisateur loueur) {
        this.loueur = loueur;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public long getDe() {
        return de;
    }

    public void setDe(long de) {
        this.de = de;
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }
}