package com.luguga.bazar.service;

import com.luguga.bazar.model.Producto;
import java.util.List;

public interface IProductoService {
    public Producto getProducto(Long id);
    public void saveProducto(Producto p);
    public List<Producto> findProductos();
    public void editProducto(Long id, String nombre, String marca, Double costo, Double cant_disp);
    public void deleteProducto(Long id);
    public List<Producto> pocoStock();
}
