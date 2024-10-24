package com.luguga.bazar.controller;

import com.luguga.bazar.dto.VentaDTO;
import com.luguga.bazar.model.Cliente;
import com.luguga.bazar.model.Producto;
import com.luguga.bazar.model.Venta;
import com.luguga.bazar.service.IVentaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaServ;
    
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta v){
        ventaServ.saveVenta(v);
        return "Venta guardada correctamente";
    }
    
    @GetMapping("/ventas")
    public List<Venta> mostrarVentas(){
        return ventaServ.findVentas();
    }
    
    @GetMapping("/ventas/{id}")
    public Venta traerVenta(@PathVariable Long id){
        return ventaServ.getVenta(id);
    }
    
    @DeleteMapping("/ventas/eliminar/{id}")
    public String borrarVenta(@PathVariable Long id){
        ventaServ.deleteVenta(id);
        return "Venta eliminada";
    }
    
    @PutMapping("/ventas/editar/{id}")
    public String editarVenta(@PathVariable Long id,
                                @RequestParam(required=false, name="fecha") Date fecha,
                                @RequestParam(required=false, name="lista") List<Producto> lista,
                                @RequestParam(required=false, name="total") Double total,
                                @RequestParam(required=false, name="cliente") Cliente cliente){
        ventaServ.editVenta(id, fecha, lista, total, cliente);
        return "Venta editada correctamente";
    }
    
    @GetMapping("/ventas/productos/{id}")
    public List<Producto> productosVenta(@PathVariable Long id){
        Venta v = this.traerVenta(id);
        return v.getListaProductos();
    }
    
    @GetMapping("/ventas/reporte/{fecha}")
    public String reporteDiario(@PathVariable String fecha){
        return ventaServ.ventaDiaria(fecha);
    }
    
    @GetMapping("/ventas/venta_mayor")
    public VentaDTO traerVentaMayor(){
        return ventaServ.datosVentaMayor();
    }
}
