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

    private String img;

    private boolean available;

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

    public String getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(String nbPlace) {
        this.nbPlace = nbPlace;
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
}
