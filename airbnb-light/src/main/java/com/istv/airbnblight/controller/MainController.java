package com.istv.airbnblight.controller;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        String prenom = null;
        String nom = null;
        if (principal instanceof UtilisateurPrincipal) {
             username = ((UtilisateurPrincipal)principal).getUsername();
            prenom = ((UtilisateurPrincipal)principal).getFirstName();
            nom = ((UtilisateurPrincipal)principal).getLastName();
        } else {
             username = principal.toString();
        }

        model.addAttribute("username", username);
        model.addAttribute("prenom", prenom);
        model.addAttribute("nom", nom);
        return "user";
    }
}