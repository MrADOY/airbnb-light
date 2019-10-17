package com.istv.airbnblight.controller;

import com.istv.airbnblight.model.Hebergement;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.HebergementServiceOdt;
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
public class HebergementController {
    @Autowired
    private HebergementService hebergementService;

    @ModelAttribute("hebergement")
    public HebergementServiceOdt hebergementDto() {
        return new HebergementServiceOdt();
    }

    @GetMapping("/hebergement/{id}/show")
    public String showHebergement(@PathVariable long id, Model model) {
      Hebergement hebergement = hebergementService.findById(id);

      model.addAttribute("hebergement", hebergement);
      return "hebergement";
     }
}
