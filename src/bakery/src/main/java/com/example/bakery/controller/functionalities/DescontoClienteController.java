package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.DescontoClienteDTO;
import com.example.bakery.repositories.entities.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class DescontoClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("desconto-cliente")
    public List<DescontoClienteDTO> getDescontoCliente(){
        List<DescontoClienteDTO> descontoClienteList = clienteRepository.getDescontoCliente();
        return descontoClienteList;
    }

}
