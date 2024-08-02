package com.spring_app.Entidad;


import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class Usuario {

    @Size(min=3,max=10)
    @NotBlank
    @Pattern(regexp = "[A-Za-z ]+", message = "El nombre solo puede contener letras y espacios")
    private String nombre;

    @Size(min=3, max=10)
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9 ]+", message = "El usuario solo puede contener letras, espacios y números")
    private String usuario;

    @NotNull
    @Size(min=8,max=12)
    @Pattern(regexp = "^" +
            "(?=.*[a-z])" +
            "(?=.*[A-Z])" +
            "(?=.*\\d)" +
            "(?=.*[@$!%*?&])" +
            "[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial")
    private String password;



    @Email(message = "Correo real")
    @NotBlank
    private String email;




}
