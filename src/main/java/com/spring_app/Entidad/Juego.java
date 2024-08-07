package com.spring_app.Entidad;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String titulo;
    private String genero;
    private String imagen;
    private String video;
    private String descripcion;
    private double precio ;
    private String plataforma;
}
