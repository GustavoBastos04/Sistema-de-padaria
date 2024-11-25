package com.example.bakery.controller.entities;

import com.example.bakery.dtos.functionalitiesdtos.ClienteDTO;
import com.example.bakery.dtos.entitydtos.ClienteRequestDTO;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.ClienteRepository;
import com.example.bakery.repositories.entities.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class ClienteController {

    // CLIENTE
    @Autowired
    ClienteRepository clientRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    // Exemplo de uso: localhost:8080/padaria/cliente/
    @GetMapping("cliente")
    public List<ClienteDTO> getClients(){
        return clientRepository.getClientes();
    }

    @PostMapping("cliente")
    public void saveClients(@RequestBody ClienteRequestDTO novoCliente){
        Endereco enderecoData = new Endereco(novoCliente);
        enderecoRepository.save(enderecoData);

        // Criar e salvar o cliente
        Cliente clientData = new Cliente(novoCliente);
        clientRepository.save(clientData);
    }
}
