package com.luguga.bazar.service;

import com.luguga.bazar.dto.VentaDTO;
import com.luguga.bazar.model.Cliente;
import com.luguga.bazar.model.Producto;
import com.luguga.bazar.model.Venta;
import java.util.Date;
import java.util.List;

public interface IVentaService {
    public Venta getVenta(Long id);
    public void saveVenta(Venta v);
    public List<Venta> findVentas();
    public void editVenta(Long id, Date fecha, List<Producto> listaProductos, Double total, Cliente cliente);
    public void deleteVenta(Long id);
    public String ventaDiaria(String fecha);
    public VentaDTO datosVentaMayor();
}
