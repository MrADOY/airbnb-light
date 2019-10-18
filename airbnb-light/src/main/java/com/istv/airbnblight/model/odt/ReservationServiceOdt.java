package com.istv.airbnblight.model.odt;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.istv.airbnblight.model.Utilisateur;

public class ReservationServiceOdt {

    private long idHebergement;

    private Utilisateur locataire;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;

    public ReservationServiceOdt() {
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
