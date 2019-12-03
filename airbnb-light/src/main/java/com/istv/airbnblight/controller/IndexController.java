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

   // @Autowired
   // @Qualifier("mysqlJdbcTemplate")
   // private JdbcTemplate mysqlTemplate;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
