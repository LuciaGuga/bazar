package com.luguga.bazar.controller;

import com.luguga.bazar.model.Cliente;
import com.luguga.bazar.service.IClienteService;
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
public class ClienteController {
    @Autowired 
    private IClienteService clienteServ;
    
    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente c){
        clienteServ.saveCliente(c);
        return "Cliente guardado correctamente";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> mostrarClientes(){
        return clienteServ.findClientes();
    }
    
    @GetMapping("/clientes/{id}")
    public Cliente traerCliente(@PathVariable Long id){
        return clienteServ.getCliente(id);
    }
    
    @DeleteMapping("/clientes/eliminar/{id}")
    public String borrarCliente(@PathVariable Long id){
        clienteServ.deleteCliente(id);
        return "Cliente eliminado";
    }
    
    @PutMapping("/clientes/editar/{id}")
    public String editarClientes(@PathVariable Long id,
                                @RequestParam(required=false, name="dni") String dni,
                                @RequestParam(required=false, name="nombre") String nombre,
                                @RequestParam(required=false, name="apellido") String apellido){
        clienteServ.editCliente(id, dni,nombre, apellido);
        return "Cliente editado correctamente";
    }
}
