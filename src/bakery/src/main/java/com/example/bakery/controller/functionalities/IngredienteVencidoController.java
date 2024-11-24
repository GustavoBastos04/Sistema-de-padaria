package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.ConsultaEstoqueIngredienteDTO;
import com.example.bakery.repositories.entities.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("padaria")
public class IngredienteVencidoController {
    @Autowired
    IngredienteRepository ingredienteRepository;

    @GetMapping("ingrediente-vencido")
    public List<ConsultaEstoqueIngredienteDTO> getIngredienteVencido(){
        Date date = Date.valueOf(LocalDate.now());

        return ingredienteRepository.getIngredienteVencido(date);
    }
}
