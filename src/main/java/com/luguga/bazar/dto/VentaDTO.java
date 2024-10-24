package com.luguga.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaDTO {
    private Long cod_venta;
    private Double total;
    private Integer cant_prod;
    private String nombre_cliente;
    private String apellido;

    public VentaDTO() {
    }

    public VentaDTO(Long cod_venta, Double total, Integer cant_prod, String nombre_cliente, String apellido) {
        this.cod_venta = cod_venta;
        this.total = total;
        this.cant_prod = cant_prod;
        this.nombre_cliente = nombre_cliente;
        this.apellido = apellido;
    }

}
