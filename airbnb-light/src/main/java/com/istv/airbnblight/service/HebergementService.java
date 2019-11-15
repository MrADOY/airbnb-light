package com.istv.airbnblight.service;

import com.istv.airbnblight.model.Hebergement;

import java.util.List;

public interface HebergementService {
    List<Hebergement> findAll();
    Hebergement findById(long id);
    List<Hebergement> findHebergementUtilisateur();
}
