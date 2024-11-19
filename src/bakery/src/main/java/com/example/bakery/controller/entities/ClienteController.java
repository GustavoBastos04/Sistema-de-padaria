package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.cliente.ClienteRequestDTO;
import com.example.bakery.dtos.entitydtos.cliente.ClienteResponseDTO;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class ClienteController {

    // CLIENTE
    @Autowired
    ClienteRepository clientRepository;
    // Exemplo de uso: localhost:8080/padaria/cliente/
    @GetMapping("cliente")
    public List<ClienteResponseDTO> getClients(){
        List<ClienteResponseDTO> clientList = clientRepository.getClientes().stream().map(ClienteResponseDTO::new).toList();
        return clientList;
    }
    @PostMapping("cliente")
    public void saveClient(@RequestBody ClienteRequestDTO newClient){
        Cliente clientData = new Cliente(newClient);
        clientRepository.save(clientData);
        return;
    }

}
