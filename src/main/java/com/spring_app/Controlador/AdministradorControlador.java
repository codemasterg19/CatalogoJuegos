package com.spring_app.Controlador;

import com.spring_app.Entidad.Juego;
import com.spring_app.Entidad.Usuario;
import com.spring_app.Servicio.JuegoServicio;
import com.spring_app.Servicio.UsuarioServicio;
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
    public String panelAdministrador() {
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
    public String formularioJuego(Model model) {
        model.addAttribute("juego", new Juego());
        return "/Juegos/formularioJuego";
    }


    // Nuevo método para catalogoRevision
    @GetMapping("/editarJuego")
    public String catalogoRevision(Model model) {
        List<Juego> juegos = juegoServicio.listarJuegos();
        model.addAttribute("juegos", juegos);
        return "/Juegos/editarJuego";
    }

    //Actualizar
    @GetMapping("/editarJ/{id}")
    public String actualizarJuego(@PathVariable Long id, Model model) {
        Optional<Juego> juego = juegoServicio.buscarJuego(id);
        model.addAttribute("juego", juego);
        return "/Juegos/formularioJuego";
    }

    //Guardar
    @PostMapping("/guardarJ")
    public String crearJuego(Juego juego) {
        juegoServicio.guardarJuego(juego);
        return "redirect:/admin/editarJuego";
    }


    //Eliminar
    @GetMapping("eliminarJ/{id}")
    public String borrarJuego(@PathVariable Long id) {
        juegoServicio.eliminarJuego(id);
        return "redirect:/admin/editarJuego";
    }

    @Autowired
    UsuarioServicio usuarioServicio;

    //  REGISTRO USUARIO


    //Leer usuario
    @GetMapping("/editarUsuario")
    public String ListaUsuarios(Model model) {
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "/Usuario/editarUsuario";
    }


    //Eliminar
    @GetMapping("/eliminarU/{id}")
    public String borrarusuario(@PathVariable Long id) {
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/admin/editarUsuario";
    }

    //Crear
    @GetMapping("/formularioUsuario")
    public String formularioUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/Usuario/formularioUsuario";
    }

    // Procesar el formulario de registro
    @PostMapping("/registrarUsuario")
    public String registrarUsuario(
            @RequestParam String nombre,
            @RequestParam String user,
            @RequestParam String email,
            @RequestParam String password, Model model) {

        try {
            usuarioServicio.guadarClientes(nombre, user, email, password);
            model.addAttribute("exito", "Registro exitoso");
            return "redirect:/admin/editarUsuario";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/admin/formularioUsuario";
        }


    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioServicio.buscarUsuario(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "/Usuario/formularioUsuario";
        } else {
            // Manejar el caso en que el usuario no se encuentra
            return "redirect:/admin/editarUsuario";
        }
    }

    @GetMapping("/logout")
    public String cerrarSesion() {
        return "login";
    }

}
