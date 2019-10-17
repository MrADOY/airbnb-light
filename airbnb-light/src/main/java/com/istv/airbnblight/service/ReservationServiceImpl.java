package com.istv.airbnblight.service;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Role;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.repository.ReservationRepository;
import com.istv.airbnblight.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Reservation save(ReservationServiceOdt registration){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        long idLoueur = 0;
        if (principal instanceof UtilisateurPrincipal) {
            idLoueur = ((UtilisateurPrincipal) principal).getId();
        }
        Reservation res = new Reservation();
        res.setLoueur(utilisateurRepository.findById(idLoueur).get());
        res.setProprietaire(reservationRepository.findById(registration.getIdHebergement()).get().getProprietaire());
        res.setDe(registration.getDe());
        res.setA(registration.getA());
        return reservationRepository.save(res);
    }
}
