package com.spring_app.Servicio;

import com.spring_app.Entidad.Factura;
import com.spring_app.Entidad.Juego;
import com.spring_app.Repositorio.JuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JuegoServicio {
    @Autowired
    private JuegoRepositorio juegoRepositorio;

   /* // Método para buscar juegos por nombre que contienen una cadena
    public List<Juego> buscarJuegosPorNombre(String nombre) {
        return juegoRepositorio.findByNombreContaining(nombre);
    }*/

    //Leer
    public List<Juego> listarJuegos(){
        return juegoRepositorio.findAll();
    }

    public Optional<Juego> buscarJuego(Long id){
        return juegoRepositorio.findById(id);
    }

    public void guardarJuego(Juego juego){

        juegoRepositorio.save(juego);
    }

    public void eliminarJuego(Long id){
        juegoRepositorio.deleteById(id);
    }

    /*public List<Juego> buscarJuegosPorNombre(String nombre) {
        return juegoRepositorio.findByNombreContainingIgnoreCase(nombre);
    }*/



}
