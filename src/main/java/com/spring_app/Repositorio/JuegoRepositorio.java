package com.spring_app.Repositorio;



import com.spring_app.Entidad.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego, Long> {

    // Método para buscar juegos que contienen una cadena en su nombre (usando LIKE)
  /*  List<Juego> findByNombreContaining(String nombre);*/
}
