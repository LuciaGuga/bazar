package com.luguga.bazar.service;

import com.luguga.bazar.dto.VentaDTO;
import com.luguga.bazar.model.Cliente;
import com.luguga.bazar.model.Producto;
import com.luguga.bazar.model.Venta;
import com.luguga.bazar.repository.IVentaRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository ventaRepo;

    @Override
    public Venta getVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void saveVenta(Venta v) {
        ventaRepo.save(v);
    }

    @Override
    public List<Venta> findVentas() {
        return ventaRepo.findAll();
    }
    
    @Override
    public void editVenta(Long id, Date fecha, List<Producto> listaProductos, Double total, Cliente cliente) {
        Venta v = this.getVenta(id);
        if(fecha != null) v.setFecha(fecha);
        if(listaProductos != null) v.setListaProductos(listaProductos);
        if(total != null) v.setTotal(total);
        if(cliente != null) v.setCliente(cliente);
        this.saveVenta(v);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public String ventaDiaria(String fecha) {        
        List<Venta> listaVentas = this.findVentas();
        List<Venta> ventasDiarias = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for(Venta v : listaVentas){
            Date f = v.getFecha();
            String fechaComoString = sdf.format(f);
            if(fechaComoString.equals(fecha))
               ventasDiarias.add(v);
        }
        int cont = 0;
        double sum = 0;
        for(Venta v : ventasDiarias){
            cont++;
            sum+= v.getTotal();
        }
                    
        return "En fecha " + fecha + " se tuvo " + cont + " ventas, "
                + "ingresando un total de " + sum + " bolivianos.";
    }

    @Override
    public VentaDTO datosVentaMayor() {
        List<Venta> listaVentas = this.findVentas();
        Venta ventaMayor = new Venta();
        double mayor = 0;
        
        for(Venta v : listaVentas){
            if (v.getTotal()>mayor){
                ventaMayor = v;
                mayor = v.getTotal();
            }
        }
        
        VentaDTO ventaDto = new VentaDTO();
        ventaDto.setCod_venta(ventaMayor.getCod_venta());
        ventaDto.setTotal(ventaMayor.getTotal());
        ventaDto.setCant_prod(ventaMayor.getListaProductos().size());
        ventaDto.setNombre_cliente(ventaMayor.getCliente().getNombre());
        ventaDto.setApellido(ventaMayor.getCliente().getApellido());
           
        return ventaDto;
    }
}
