package com.spring_app.Repositorio;



import com.spring_app.Entidad.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego, Long> {
}
