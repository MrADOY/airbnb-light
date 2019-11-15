package com.istv.airbnblight.service;

import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Utilisateur;

public interface UtilisateurService {
    public Utilisateur findByEmail(String email);
    public Utilisateur findById(long id);
    public Utilisateur save(EnregistrementUtilisateurOdt registration);
    public Utilisateur update(String email, EnregistrementUtilisateurOdt registration);
}
