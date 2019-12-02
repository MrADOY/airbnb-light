package com.istv.airbnblight.service;

import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;

import java.util.List;

public interface ReservationService {

    public Reservation save(ReservationServiceOdt reservation);

    public Reservation save(Reservation reservation);

    public Reservation findById(Long id);

    public List<Reservation> findByIsConfirmeeFalse();

    List<Reservation> getReservationsAValider();

}
