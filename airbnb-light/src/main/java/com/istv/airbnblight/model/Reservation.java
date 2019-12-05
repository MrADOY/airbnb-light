package com.istv.airbnblight.model;


import javax.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.Hebergement;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locataire")
    private Utilisateur locataire;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "herbergement")
    private Hebergement hebergement;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;

    private boolean isConfirmee;

    public boolean isConfirmee() {
        return isConfirmee;
    }

    public void setConfirmee(boolean confirmee) {
        this.isConfirmee = confirmee;
    }

    public Hebergement getHebergement() {
        return hebergement;
    }

    public void setHebergement(Hebergement hebergement) {
        this.hebergement = hebergement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getLocataire() {
        return locataire;
    }

    public void setLocataire(Utilisateur locataire) {
        this.locataire = locataire;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
