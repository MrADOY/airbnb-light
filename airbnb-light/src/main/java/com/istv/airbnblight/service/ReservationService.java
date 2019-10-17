package com.istv.airbnblight.service;

import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;

public interface ReservationService {

    public Reservation save(ReservationServiceOdt reservation);

}
