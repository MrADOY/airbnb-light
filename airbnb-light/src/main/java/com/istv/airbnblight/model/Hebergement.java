package com.istv.airbnblight.model;

import javax.persistence.*;

@Entity
@Table(name = "accommodation")
public class Hebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeHebergement;

    private String nbPlace;

    private String nom;

    private String description;

    private String adresse;

    private String ville;

    private String pays;

    private String cp;

    private Double prixJour;

    private Double prixPers;

    private String img;

    private boolean available = true;

    @ManyToOne
    private Utilisateur proprietaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeHebergement() {
        return typeHebergement;
    }

    public void setTypeHebergement(String typeHebergement) {
        this.typeHebergement = typeHebergement;
    }

    public void setNbPlace(String nbPlace) {
      this.nbPlace = nbPlace;
    }

    public String getNbPlace() {
        return nbPlace;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPays() {
        return pays;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCp() {
        return cp;
    }

    public Double getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(Double prixJour) {
        this.prixJour = prixJour;
    }

    public Double getPrixPers() {
        return prixPers;
    }

    public void setPrixPers(Double prixPers) {
        this.prixPers = prixPers;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }
}
