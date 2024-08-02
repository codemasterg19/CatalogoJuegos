package com.spring_app.Controlador;


import com.spring_app.Entidad.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroControlador {

    @GetMapping("/registro")
    public String formularioAutor(Model model){
        model.addAttribute("usuario",new Usuario());
        return  "registro";
    }
    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "registro";
        }else{

            return "index";
        }
    }
}
