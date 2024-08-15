package com.spring_app.Controlador;

import com.spring_app.Entidad.Juego;
import com.spring_app.Servicio.JuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdministradorControlador {

    @Autowired
    JuegoServicio juegoServicio;

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


    //Crear
    @GetMapping("/formularioJuego")
    public String formularioJuego(Model model){
        model.addAttribute("juego",new Juego());
        return "/Juegos/formularioJuego";
    }


    // Nuevo método para catalogoRevision
    @GetMapping("/editarJuego")
    public String catalogoRevision(Model model){
        List<Juego> juegos = juegoServicio.listarJuegos();
        model.addAttribute("juegos", juegos);
        return "/Juegos/editarJuego";
    }

    //Actualizar
    @GetMapping("/editarJ/{id}")
    public String actualizarJuego(@PathVariable Long id, Model model){
        Optional<Juego> juego = juegoServicio.buscarJuego(id);
        model.addAttribute("juego",juego);
        return "/Juegos/formularioJuego";
    }

    //Guardar
    @PostMapping("/guardarJ")
    public String crearJuego(Juego juego){
        juegoServicio.guardarJuego(juego);
        return "redirect:/editarJuego";
    }


    //Eliminar
    @GetMapping("/eliminarJ/{id}")
    public String borrarJuego(@PathVariable Long id){
        juegoServicio.eliminarJuego(id);
        return "redirect:/editarJuego";
    }





}
