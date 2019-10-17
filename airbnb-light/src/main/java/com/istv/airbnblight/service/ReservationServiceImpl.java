package com.istv.airbnblight.service;

import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Role;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.repository.ReservationRepository;
import com.istv.airbnblight.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public Reservation save(ReservationServiceOdt registration){
        Reservation res = new Reservation();


        return reservationRepository.save(res);
    }
}
