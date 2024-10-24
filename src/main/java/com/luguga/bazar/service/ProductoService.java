package com.luguga.bazar.service;

import com.luguga.bazar.model.Producto;
import com.luguga.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public Producto getProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto p) {
        productoRepo.save(p);
    }

    @Override
    public List<Producto> findProductos() {
        return productoRepo.findAll();
    }
    
    @Override
    public void editProducto(Long id, String nombre, String marca, 
            Double costo, Double cant_disp) {
        Producto p = this.getProducto(id);
        if(nombre != null) p.setNombre(nombre);
        if(marca != null) p.setMarca(marca);
        if(costo != null) p.setCosto(costo);
        if(cant_disp != null) p.setCant_disp(cant_disp);
        this.saveProducto(p);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public List<Producto> pocoStock() {
        List<Producto> listaCompleta = this.findProductos();
        List<Producto> listaFalta = new ArrayList<>();
        for(Producto p : listaCompleta){
            if(p.getCant_disp()<5)
                listaFalta.add(p);
        }
        return listaFalta;
    }
}
