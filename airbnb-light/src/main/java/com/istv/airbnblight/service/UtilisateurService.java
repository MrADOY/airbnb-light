package com.istv.airbnblight.service;

import com.istv.airbnblight.model.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Utilisateur;

public interface UtilisateurService {
    public Utilisateur findByEmail(String email);
    public Utilisateur save(EnregistrementUtilisateurOdt registration);
}
