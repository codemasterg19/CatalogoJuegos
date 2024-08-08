package com.spring_app.Entidad;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String numeroFactura;
    private LocalDate fecha;
    private Double precio_total;

    @ManyToOne
    @JoinColumn(name="id_compra")
    private Juego juego;

    @ManyToOne
    @JoinColumn(name="id_juego")
    private  Usuario usuario;

}
