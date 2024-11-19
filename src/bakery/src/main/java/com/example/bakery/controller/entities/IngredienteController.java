package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.IngredienteDTO;
import com.example.bakery.entities.Ingrediente;
import com.example.bakery.repositories.entities.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class IngredienteController {

    // INGREDIENTE
    @Autowired
    IngredienteRepository ingredienteRepository;
    @GetMapping("ingrediente")
    public List<IngredienteDTO> getIngrediente(){
        List<IngredienteDTO> ingredienteList = ingredienteRepository.getIngredientes().stream().map(IngredienteDTO::new).toList();
        return ingredienteList;
    }
    @PostMapping("ingrediente")
    public void saveIngrediente(@RequestBody IngredienteDTO newIngrediente){
        Ingrediente ingredienteData = new Ingrediente(newIngrediente);
        ingredienteRepository.save(ingredienteData);
        return;
    }
}
