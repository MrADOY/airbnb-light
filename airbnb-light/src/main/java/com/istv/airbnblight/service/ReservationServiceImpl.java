package com.istv.airbnblight.service;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.repository.HebergementRepository;
import com.istv.airbnblight.repository.ReservationRepository;
import com.istv.airbnblight.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReservationServiceImpl implements ReservationService {

  public List<Reservation> reservationsAValider;

  public List<Reservation> reservationsUtilisateur;

  public List<Reservation> reservationsHebergementUtilisateur;

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

  @Override
  public List<Reservation> findByIsConfirmeeFalse(){
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    long idUser = 0;
    if (principal instanceof UtilisateurPrincipal) {
      idUser = ((UtilisateurPrincipal) principal).getId();
    }

    if(reservationsAValider == null){
      reservationsAValider = new ArrayList<>();
    }
    reservationsAValider = reservationRepository.findByIsConfirmeeFalseAndHebergementProprietaireId(idUser);
    return reservationsAValider;

  }

  public List<Reservation> getReservationsAValider() {
    return reservationsAValider;
  }

  @Override
  public List<Reservation> findReservationUtilisateur() {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    long idUser = 0;
    if (principal instanceof UtilisateurPrincipal) {
      idUser = ((UtilisateurPrincipal) principal).getId();
    }

    if(reservationsUtilisateur == null){
      reservationsUtilisateur = new ArrayList<>();
    }
    reservationsUtilisateur = reservationRepository.findByLocataireId(idUser);
    return reservationsUtilisateur;
  }

  @Override
  public List<Reservation> findReservationHebergementUtilisateur() {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    long idUser = 0;
    if (principal instanceof UtilisateurPrincipal) {
      idUser = ((UtilisateurPrincipal) principal).getId();
    }

    if(reservationsHebergementUtilisateur == null){
      reservationsHebergementUtilisateur = new ArrayList<>();
    }
    reservationsHebergementUtilisateur = reservationRepository.findByHebergementProprietaireId(idUser);
    return reservationsHebergementUtilisateur;
  }
}
