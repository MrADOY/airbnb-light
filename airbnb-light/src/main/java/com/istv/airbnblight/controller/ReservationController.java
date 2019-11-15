package com.istv.airbnblight.controller;

import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.service.HebergementService;
import com.istv.airbnblight.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HebergementService hebergementService;

    @ModelAttribute("reservation")
    public ReservationServiceOdt reservationDto() {
        return new ReservationServiceOdt();
    }

    @GetMapping("/reservation")
    public String reservationIndex(Model model) {
        model.addAttribute("annonces", hebergementService.findAll());
        reservationService.findByIsConfirmeeTrue();
        model.addAttribute("reservationAValider", reservationService.getReservationsAValider());

        return "reservation";
    }

    @PostMapping("/reservation")
    public String listerReservation(@ModelAttribute("reservation") @Valid ReservationServiceOdt resOdt,
                                      BindingResult result){
        Reservation existing = reservationService.save(resOdt);
        return "redirect:/reservation?success";
    }

    @GetMapping("/reservation/reserver")
    public String findReservation(Model model, @RequestParam(name = "id_hebergement") long id_hebergement){
        Hebergement hebergement = hebergementService.findById(id_hebergement);

        model.addAttribute("hebergement", hebergement);
        return "reservation_form";
    }

    @GetMapping("/reservation/accepter-reservation")
    public String registerUserAccount(Model model){
        List<Reservation> reservations = reservationService.findByIsConfirmeeTrue();
        model.addAttribute("reservationsAValider", reservations);
        return "reservation_form";
    }

    @GetMapping("/reservation/lister-reservation-a-valider")
    public String listerReservationAValider(Model model, @RequestParam(name = "id_reservation") long id_reservation){
        Reservation reservation = reservationService.findById(id_reservation);

        if(reservation != null && !reservation.isConfirmee()){
            reservation.setConfirmee(true);
            reservationService.save(reservation);
        }

        model.addAttribute("hebergement", reservation);
        return "reservation_form";
    }



}
