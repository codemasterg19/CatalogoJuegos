package com.spring_app.Entidad;


import com.spring_app.Roles.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
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

    @Enumerated(EnumType.STRING)
    private Role rol;

    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre no puede estar vacío") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre no puede estar vacío") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El usuario no puede estar vacío") @Size(min = 3, max = 50, message = "El usuario debe tener entre 3 y 50 caracteres") String getUser() {
        return user;
    }

    public void setUser(@NotBlank(message = "El usuario no puede estar vacío") @Size(min = 3, max = 50, message = "El usuario debe tener entre 3 y 50 caracteres") String user) {
        this.user = user;
    }

    public @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") @NotBlank(message = "La contraseña no puede estar vacía") String getPassword() {
        return password;
    }

    public void setPassword(@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "La contraseña debe contener al menos una letra mayúscula, un número y un carácter especial") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") @NotBlank(message = "La contraseña no puede estar vacía") String password) {
        this.password = password;
    }

    public @Email(message = "El correo electrónico debe ser válido") @NotBlank(message = "El correo electrónico no puede estar vacío") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "El correo electrónico debe ser válido") @NotBlank(message = "El correo electrónico no puede estar vacío") String email) {
        this.email = email;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}
