package com.istv.airbnblight.model;

import javax.persistence.*;

@Entity
@Table(name = "accommodation")
public class Hebergement {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String typeHebergement;

  private String nom;

  private String description;

  private String adresse;

  private String ville;

  private String pays;

  private String cp;

  private Integer nbPlace;

  private String prixJour;

  private String prixPers;

  private String image;

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

  public void setNbPlace(Integer nbPlace) {
    this.nbPlace = nbPlace;
  }

  public Integer getNbPlace() {
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

  public String getPrixJour() {
    return prixJour;
  }

  public void setPrixJour(String prixJour) {
    this.prixJour = prixJour;
  }

  public String getPrixPers() {
    return prixPers;
  }

  public void setPrixPers(String prixPers) {
    this.prixPers = prixPers;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
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
