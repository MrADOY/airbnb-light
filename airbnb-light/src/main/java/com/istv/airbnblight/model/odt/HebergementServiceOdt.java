package com.istv.airbnblight.model.odt;

public class HebergementServiceOdt {
    private Long id;
    private long proprietaireId;
    private String nom;
    private String adresse;
    private String cp;
    private String ville;
    private String pays;
    private String description;
    private String image;
    private Integer nbPlace;
    private String prixJour;
    private String prixPers;
    private String typeHebergement;

    public HebergementServiceOdt() {
    };

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public long getProprietaireId() {
        return proprietaireId;
    }

    public void setProprietaireId(long proprietaireId) {
        this.proprietaireId = proprietaireId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getPrixPers() {
        return prixPers;
    }

    public void setPrixPers(String prixPers) {
        this.prixPers = prixPers;
    }

    public String getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(String prixJour) {
        this.prixJour = prixJour;
    }

    public String getTypeHebergement() {
        return typeHebergement;
    }

    public void setTypeHebergement(String typeHebergement) {
        this.typeHebergement = typeHebergement;
    }
}
