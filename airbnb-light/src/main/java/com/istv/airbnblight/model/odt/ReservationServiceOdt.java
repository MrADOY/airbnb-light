package com.istv.airbnblight.model.odt;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.Hebergement;

public class ReservationServiceOdt {

    private long idHebergement;

    private Hebergement hebergement;

    private Utilisateur locataire;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;

    private boolean is_confirmee;

    public boolean isConfirmee() {
        return is_confirmee;
    }

    public void setConfirmee(boolean confirmee) {
        this.is_confirmee = confirmee;
    }

    public ReservationServiceOdt() {
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    public long getIdHebergement() {
        return idHebergement;
    }

    public void setIdHebergement(long idHebergement) {
        this.idHebergement = idHebergement;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Utilisateur getLocataire() {
        return locataire;
    }

    public void setLocataire(Utilisateur locataire) {
        this.locataire = locataire;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
