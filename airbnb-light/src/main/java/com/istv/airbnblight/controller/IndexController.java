package com.istv.airbnblight.controller;

import com.istv.airbnblight.config.UtilisateurPrincipal;
import com.istv.airbnblight.service.HebergementService;
import com.istv.airbnblight.service.ReservationService;
import com.istv.airbnblight.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private HebergementService herbergementService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlTemplate;

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

    @GetMapping("/reservation")
    public String reservationIndex(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Map<String, Object> map = new HashMap<>();

        // On verifie si l'utilisateur peut reserver
        String query = "SELECT * FROM UTILISATEUR";

        try {
            map = mysqlTemplate.queryForMap(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);

        model.addAttribute("annonces", herbergementService.findAll());
        reservationService.findByIsConfirmeeFalse();
        model.addAttribute("reservationAValider", reservationService.getReservationsAValider());

        return "reservation";
    }
}
