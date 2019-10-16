package com.istv.airbnblight.service;

import com.istv.airbnblight.model.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Utilisateur;

import java.util.List;

public interface HebergementService {
    List<Hebergement> findAll();
}
