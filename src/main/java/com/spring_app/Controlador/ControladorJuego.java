package com.spring_app.Controlador;

import com.spring_app.Entidad.Juego;
import com.spring_app.Servicio.JuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorJuego {

    @Autowired
    JuegoServicio juegoServicio;

    /*@GetMapping("/juegos/buscar")
    public String buscarPorNombreConteniendo(@RequestParam String nombre, Model model) {
        List<Juego> juegos = juegoServicio.buscarJuegosPorNombre(nombre);
        model.addAttribute("juegos", juegos);
        return "/Juegos/vistaJuegos";
    }*/

    //Crear
    @GetMapping("/formularioJuego")
    public String formularioJuego(Model model){
        model.addAttribute("juego",new Juego());
        return "/Juegos/formularioJuego";
    }

    //Leer
    @GetMapping("/juegos")
    public String mostrarJuegos(Model model){
        List<Juego> juegos = juegoServicio.listarJuegos();
        model.addAttribute("juegos",juegos);
        return "/Juegos/listarJuegos";
    }

    //Guardar
    @PostMapping("/guardarJ")
    public String crearJuego(Juego juego){
        juegoServicio.guardarJuego(juego);
        return "redirect:/juegos";
    }

    //Actualizar
    @GetMapping("/editarJ/{id}")
    public String actualizarJuego(@PathVariable Long id, Model model){
        Optional<Juego> juego = juegoServicio.buscarJuego(id);
        model.addAttribute("juego", juego);
        return "/Juegos/formularioJuego";
    }

    //Eliminar
    @GetMapping("/eliminarJ/{id}")
    public String borrarJuego(@PathVariable Long id){
        juegoServicio.eliminarJuego(id);
        return "redirect:/juegos";
    }


}
