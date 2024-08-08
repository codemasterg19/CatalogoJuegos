package com.spring_app.Controlador;

import com.spring_app.Entidad.Juego;
import com.spring_app.Servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorFactura {

    @Autowired
    FacturaServicio facturaServicio;

    @GetMapping("/facturas")
    public String buscarJuegoByFactura(@RequestParam(value = "numeroFactura", required= false) String numeroFactura, Model model){
        if(numeroFactura!=null && !numeroFactura.isEmpty()){
            List<Juego> juegos=facturaServicio.buscasJuegosPorFactura(numeroFactura);
            model.addAttribute("juegos", juegos);
        }
        return "factura";
    }
}
