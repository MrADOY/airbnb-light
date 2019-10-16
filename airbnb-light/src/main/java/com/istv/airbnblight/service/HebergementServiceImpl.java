package com.istv.airbnblight.service;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Role;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.repository.HebergementRepository;
import com.istv.airbnblight.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HebergementServiceImpl implements HebergementService {

    @Autowired
    private HebergementRepository hebergementRepository;

    public List<Hebergement> findAll(){
        return StreamSupport
                .stream(hebergementRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}