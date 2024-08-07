package com.spring_app.Entidad;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String nombre;
    private String user;
    private String password;
    private String email;




}
