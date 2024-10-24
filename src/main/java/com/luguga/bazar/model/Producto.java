package com.luguga.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cod_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cant_disp;

    public Producto() {
    }

    public Producto(Long cod_producto, String nombre, String marca, Double costo, Double cant_disp) {
        this.cod_producto = cod_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cant_disp = cant_disp;
    }
    
}
