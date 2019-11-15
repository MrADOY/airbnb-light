package com.istv.airbnblight.service;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.odt.HebergementServiceOdt;
import com.istv.airbnblight.repository.HebergementRepository;
import com.istv.airbnblight.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HebergementServiceImpl implements HebergementService {

    @Autowired
    private HebergementRepository hebergementRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Hebergement> findAll(){
        return StreamSupport
                .stream(hebergementRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Hebergement findById(long id){
        return hebergementRepository.findById(id).get();
    }

    @Override
    public Hebergement save(HebergementServiceOdt hebergement){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        long idProprio = 0;
        if (principal instanceof UtilisateurPrincipal) {
            idProprio = ((UtilisateurPrincipal) principal).getId();
        }

        Hebergement heb = new Hebergement();
        heb.setProprietaire(utilisateurRepository.findById(idProprio).get());

        return hebergementRepository.save(heb);
    }

    @Override
    public Hebergement save(Hebergement hebergement){
        return hebergementRepository.save(hebergement);
    }

    @Override
    public List<Hebergement> findHebergementUtilisateur() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        long idUser = 0;
        if (principal instanceof UtilisateurPrincipal) {
            idUser = ((UtilisateurPrincipal) principal).getId();
        }
        return hebergementRepository.findByProprietaireId(idUser);
    }



}
