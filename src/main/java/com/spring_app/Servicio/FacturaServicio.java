package com.spring_app.Servicio;


import com.spring_app.Entidad.Factura;
import com.spring_app.Entidad.Juego;
import com.spring_app.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public List<Juego> buscasJuegosPorFactura(String numeroFactura){
        return facturaRepositorio.findByNumeroFactura(numeroFactura).stream()
                .map(Factura::getJuego)
                .collect(Collectors.toList());
    }



}
