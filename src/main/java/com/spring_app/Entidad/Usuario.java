package com.spring_app.Entidad;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El usuario no puede estar vacío")
    @Size(min = 3, max = 50, message = "El usuario debe tener entre 3 y 50 caracteres")
    private String user;



    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;


    @Email(message = "El correo electrónico debe ser válido")
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;



}
