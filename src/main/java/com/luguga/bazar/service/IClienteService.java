package com.luguga.bazar.service;

import com.luguga.bazar.model.Cliente;
import java.util.List;

public interface IClienteService {
    public Cliente getCliente(Long id);
    public void saveCliente(Cliente c);
    public List<Cliente> findClientes();
    public void editCliente(Long id, String dni, String nombre, String apellido);
    public void deleteCliente(Long id);
}
