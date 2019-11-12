package com.istv.airbnblight.service;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Role;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.repository.HebergementRepository;
import com.istv.airbnblight.repository.ReservationRepository;
import com.istv.airbnblight.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    HebergementRepository hebergementRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Reservation save(ReservationServiceOdt registration){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        long idLocataire = 0;
        if (principal instanceof UtilisateurPrincipal) {
            idLocataire = ((UtilisateurPrincipal) principal).getId();
        }

        Reservation res = new Reservation();
        res.setLocataire(utilisateurRepository.findById(idLocataire).get());

        Hebergement her = hebergementRepository.findById(registration.getIdHebergement()).get();
        her.setAvailable(false);
        hebergementRepository.save(her);
        res.setStart(registration.getStart());
        res.setEnd(registration.getEnd());
        res.setHebergement(her);
        return reservationRepository.save(res);
    }

    @Override
    public Reservation save(Reservation registration){
        return reservationRepository.save(registration);
    }

    @Override
    public Reservation findById(Long idReservation){
        Optional<Reservation> reservation = reservationRepository.findById(idReservation);

        if(reservation.isPresent()){
            reservation.get().setConfirmee(true);
            reservationRepository.save(reservation.get());
            return reservation.get();
        } else {
            return null;
        }

    }
}
