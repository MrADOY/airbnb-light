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
    @JoinColumn(name = "herbergement")
    private Hebergement hebergement;

    private long start;

    private long end;


    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

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

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
