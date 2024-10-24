package com.luguga.bazar.service;

import com.luguga.bazar.model.Cliente;
import com.luguga.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(Cliente c) {
        clienteRepo.save(c);
    }

    @Override
    public List<Cliente> findClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void editCliente(Long id, String dni, String nombre, String apellido) {
        Cliente c = this.getCliente(id);
        c.setDni(dni);
        c.setNombre(nombre);
        c.setApellido(apellido);
        this.saveCliente(c);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    
}
