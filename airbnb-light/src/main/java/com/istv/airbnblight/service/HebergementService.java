package com.istv.airbnblight.service;

import com.istv.airbnblight.model.odt.HebergementServiceOdt;
import com.istv.airbnblight.model.Hebergement;

import java.util.List;

public interface HebergementService {
    List<Hebergement> findAll();
    Hebergement findById(long id);
    public Hebergement save(HebergementServiceOdt hebergement);
    public Hebergement save(Hebergement hebergement);    
    List<Hebergement> findHebergementUtilisateur();
}
