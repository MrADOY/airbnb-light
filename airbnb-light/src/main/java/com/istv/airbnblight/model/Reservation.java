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

}