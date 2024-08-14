package com.spring_app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

    @GetMapping("/dashboard")
    public String panelAdministrador(){
        return "/Administrador/panelControl";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "logout", required = false) String logout) {
        if (logout != null) {
            model.addAttribute("message", "Sesion finalizada exitosamente.");
        }
        return "login";
    }



}
