package com.airbnb.aws.airbnbutils.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facturation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String montant;

    private long idLocataire;

    public Facturation(String montant, long idLocataire) {
        this.montant = montant;
        this.idLocataire = idLocataire;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public long getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(int idLocataire) {
        this.idLocataire = idLocataire;
    }
}
