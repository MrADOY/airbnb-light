package com.istv.airbnblight.repository;


import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByIsConfirmeeFalseAndHebergementProprietaireId(Long idUser);

    List<Reservation> findByHebergementProprietaireId(Long idUser);

    List<Reservation> findByLocataireId(Long idUser);

}
