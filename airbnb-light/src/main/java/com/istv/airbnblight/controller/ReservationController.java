package com.istv.airbnblight.controller;

import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Reservation;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.model.odt.ReservationServiceOdt;
import com.istv.airbnblight.service.HebergementService;
import com.istv.airbnblight.service.ReservationService;
import com.istv.airbnblight.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HebergementService hebergementService;

    @ModelAttribute("reservationodt")
    public EnregistrementUtilisateurOdt userRegistrationDto() {
        return new EnregistrementUtilisateurOdt();
    }

    @PostMapping("/reservation")
    public String registerUserAccount(@ModelAttribute("reservationodt") @Valid ReservationServiceOdt resOdt,
                                      BindingResult result){
        Reservation existing = reservationService.save(resOdt);
        return "redirect:/reservation?success";
    }

    @GetMapping("/reservation/reserver")
    public String registerUserAccount(@RequestParam("id_hebergement") @Valid long id_hebergement,
                                      BindingResult result, Model model){
        Hebergement hebergement = hebergementService.findById(id_hebergement);

        model.addAttribute("hebergement", hebergement);
        return "reservation_form";
    }
}
