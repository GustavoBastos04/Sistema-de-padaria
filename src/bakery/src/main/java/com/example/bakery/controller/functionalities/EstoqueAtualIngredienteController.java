package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.ConsultaEstoqueIngredienteDTO;
import com.example.bakery.repositories.entities.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class EstoqueAtualIngredienteController {
    @Autowired
    IngredienteRepository ingredienteRepository;

    @GetMapping("estoque-atual-ingrediente")
    public List<ConsultaEstoqueIngredienteDTO> getEstoqueAtualIngrediente(){
        return ingredienteRepository.getEstoqueAtualIngrediente();
    }
}
