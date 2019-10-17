package com.istv.airbnblight.service;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Role;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
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
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UserDetailsService, UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        Utilisateur user = utilisateurRepository.findByEmail(usernameOrEmail);
        return UtilisateurPrincipal.create(user);
    }

    @Override
    public Utilisateur findByEmail(String email){
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public Utilisateur save(EnregistrementUtilisateurOdt registration){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setFirstName(registration.getFirstName());
        utilisateur.setLastName(registration.getLastName());
        utilisateur.setEmail(registration.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(registration.getPassword()));
        utilisateur.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return utilisateurRepository.save(utilisateur);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}