package com.luguga.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long cod_venta;
    private Date fecha;
    @OneToMany
    private List<Producto> listaProductos;
    private Double total;
    @OneToOne
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long cod_venta, Date fecha, List<Producto> listaProductos, Double total, Cliente cliente) {
        this.cod_venta = cod_venta;
        this.fecha = fecha;
        this.listaProductos = listaProductos;
        this.total = total;
        this.cliente = cliente;
    }    
}
