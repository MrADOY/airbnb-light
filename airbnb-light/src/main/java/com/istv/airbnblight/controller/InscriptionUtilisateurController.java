package com.istv.airbnblight.controller;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class InscriptionUtilisateurController {

  @Autowired
  private UtilisateurService utilisateurService;

  @ModelAttribute("utilisateur")
  public EnregistrementUtilisateurOdt userRegistrationDto() {
    return new EnregistrementUtilisateurOdt();
  }

  @GetMapping("/registration")
  public String showRegistrationForm(Model model) {
    return "registration";
  }

  @PostMapping("/registration")
  public String registerUserAccount(@ModelAttribute("utilisateur") @Valid EnregistrementUtilisateurOdt userDto,
  BindingResult result){

    Utilisateur existing = utilisateurService.findByEmail(userDto.getEmail());
    if (existing != null){
      result.rejectValue("email", null, "There is already an account registered with that email");
    }

    if (result.hasErrors()){
      return "registration";
    }

    utilisateurService.save(userDto);
    return "redirect:/login";
  }

  @GetMapping("/user")
  public String userIndex(Model model) {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Utilisateur utilisateur = utilisateurService.findById(((UtilisateurPrincipal)principal).getId());
    model.addAttribute("utilisateur", utilisateur);

    return "user";
  }

  @GetMapping("/user/edit")
  public String userEdit(Model model) {

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Utilisateur utilisateur = utilisateurService.findById(((UtilisateurPrincipal)principal).getId());
    model.addAttribute("utilisateur", utilisateur);
    return "user_form";
  }

  @PostMapping("/user/update")
  public String updateUserAccount(@ModelAttribute("utilisateur") @Valid EnregistrementUtilisateurOdt userDto, BindingResult result){

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String email = ((UtilisateurPrincipal)principal).getUsername();
    Boolean existing = false;
    Utilisateur user = utilisateurService.findByEmail(userDto.getEmail());
    if (user.getId() != ((UtilisateurPrincipal)principal).getId()) {
      existing = true;
    }
    if (existing == true){
      result.rejectValue("email", null, "There is already an account registered with that email");
    }

    if (result.hasErrors()){
      return "user_form";
    }

    utilisateurService.update(email, userDto);
    return "redirect:/user";
  }
}
