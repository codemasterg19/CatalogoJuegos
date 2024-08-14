package com.spring_app.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

    @GetMapping("/dashboard")
    public String panelAdministrador(){
        return "/Administrador/panelControl";
    }
}
