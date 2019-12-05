package com.istv.airbnblight.controller;

import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.service.HebergementService;
import com.istv.airbnblight.service.ReservationService;
import com.istv.airbnblight.service.UtilisateurService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@Controller
public class ReservationController {

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private HebergementService hebergementService;

  @Autowired
  private UtilisateurService utilisateurService;

  @ModelAttribute("reservation")
  public ReservationServiceOdt reservationDto() {
    return new ReservationServiceOdt();
  }

  @GetMapping("/reservation")
  public String reservationIndex(Model model) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Utilisateur utilisateur = utilisateurService.findById(((UtilisateurPrincipal)principal).getId());
    model.addAttribute("utilisateur", utilisateur);
    model.addAttribute("annonces", hebergementService.findAll());
    reservationService.findByIsConfirmeeFalse();
    model.addAttribute("reservationAValider", reservationService.getReservationsAValider());

    return "reservation";
  }

  @PostMapping("/reservation")
  public String listerReservation(@ModelAttribute("reservation") @Valid ReservationServiceOdt resOdt, BindingResult result){
    Reservation existing = reservationService.save(resOdt);
    return "redirect:/reservation?success";
  }

  @GetMapping("/reservation/reserver")
  public String findReservation(Model model, @RequestParam(name = "id_hebergement") long id_hebergement){
    Hebergement hebergement = hebergementService.findById(id_hebergement);
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Utilisateur utilisateur = utilisateurService.findById(((UtilisateurPrincipal)principal).getId());
    model.addAttribute("utilisateur", utilisateur);
    model.addAttribute("hebergement", hebergement);
    return "reservation_form";
  }

  @GetMapping("/reservation/lister-reservation-a-valider")
  public String registerUserAccount(Model model){
    List<Reservation> reservations = reservationService.findByIsConfirmeeFalse();
    model.addAttribute("reservationsAValider", reservations);
    return "reservation_form";
  }

  @GetMapping("/reservation/accepter-reservation")
  public String accepterReservation(Model model, @RequestParam(name = "id_reservation") long id_reservation){
    Reservation reservation = reservationService.findById(id_reservation);

    if(reservation != null && !reservation.isConfirmee()){
      reservation.setConfirmee(true);
      reservationService.save(reservation);
    }

    model.addAttribute("hebergement", reservation);
    return "reservation";
  }

  @GetMapping("reservations-users")
  public String listerToutesReservations(Model model){
    model.addAttribute("reservationsHebergements", reservationService.findReservationHebergementUtilisateur());
    model.addAttribute("reservationsUtilisateur", reservationService.findReservationUtilisateur());

    return "reservations-user";
  }
}
