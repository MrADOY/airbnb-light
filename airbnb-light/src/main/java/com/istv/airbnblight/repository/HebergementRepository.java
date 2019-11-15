package com.istv.airbnblight.repository;


import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HebergementRepository extends CrudRepository<Hebergement, Long> {

    List<Hebergement> findByProprietaireId(Long id);

}