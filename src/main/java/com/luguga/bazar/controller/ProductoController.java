package com.luguga.bazar.controller;

import com.luguga.bazar.model.Producto;
import com.luguga.bazar.service.IProductoService;
import java.util.ArrayList;
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
public class ProductoController {
    @Autowired
    private IProductoService productoServ;
    
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto p){
        productoServ.saveProducto(p);
        return "Producto guardado correctamente";
    }
    
    @GetMapping("/productos")
    public List<Producto> mostrarProductos(){
        return productoServ.findProductos();
    }
    
    @GetMapping("/productos/{id}")
    public Producto traerProducto(@PathVariable Long id){
        return productoServ.getProducto(id);
    }
    
    @DeleteMapping("/productos/eliminar/{id}")
    public String borrarProducto(@PathVariable Long id){
        productoServ.deleteProducto(id);
        return "Producto eliminado";
    }
    
    @PutMapping("/productos/editar/{id}")
    public String editarProductos(@PathVariable Long id,
                                @RequestParam(required=false, name="nombre") String nombre,
                                @RequestParam(required=false, name="marca") String marca,
                                @RequestParam(required=false, name="costo") Double costo,
                                @RequestParam(required=false, name="cantidad") Double cantidad){
        productoServ.editProducto(id, nombre, marca, costo, cantidad);
        return "Producto editado correctamente";
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> traerPocoStock(){
        return productoServ.pocoStock();
    }
}
