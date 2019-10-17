package com.istv.airbnblight.controller;

import com.istv.airbnblight.model.Utilisateur;
import com.istv.airbnblight.model.odt.EnregistrementUtilisateurOdt;
import com.istv.airbnblight.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return "redirect:/registration?success";
    }

}