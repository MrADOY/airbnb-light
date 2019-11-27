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

  @GetMapping("/hebergement/{id}/edit")
  public String editHebergement(@PathVariable long id, Model model) {
    Hebergement hebergement = hebergementService.findById(id);
    model.addAttribute("id_hebergement", id);
    model.addAttribute("hebergement", hebergement);
    return "hebergement_form";
  }

  @GetMapping("/hebergement/create")
  public String createHebergement(Model model) {
    return "hebergement_form";
  }

  @PostMapping("/hebergement")
  public String saveHebergement(@ModelAttribute("hebergement") @Valid HebergementServiceOdt hebOdt,
                                    BindingResult result) {
      Hebergement existing = hebergementService.save(hebOdt);
      return "redirect:/hebergements-user?success";
  }

  @GetMapping("hebergements-user")
  public String listerHebergement(Model model){
    model.addAttribute("hebergements", hebergementService.findHebergementUtilisateur());
    return "hebergements-user";
  }
}
