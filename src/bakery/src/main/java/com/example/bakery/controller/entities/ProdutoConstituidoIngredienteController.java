package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.ProdutoConstIngredienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bakery.repositories.entities.ProdutoConstituidoIngredienteRepository;
import com.example.bakery.entities.ProdutoConstituidoIngrediente;
import java.util.List;

@RestController
@RequestMapping("padaria")
public class ProdutoConstituidoIngredienteController {

    @Autowired
    ProdutoConstituidoIngredienteRepository prodConstIngredRepository;
    @GetMapping("produto-constituido-ingrediente")
    public List<ProdutoConstIngredienteDTO> getProdConstIngred(){
        List<ProdutoConstIngredienteDTO> prodConstIngredList = prodConstIngredRepository.getProdutoConstIngred().stream().map(ProdutoConstIngredienteDTO::new).toList();
        return prodConstIngredList;
    }
    @PostMapping("produto-constituido-ingrediente")
    public void saveProduto(@RequestBody ProdutoConstIngredienteDTO newProduto){
        ProdutoConstituidoIngrediente produtoData = new ProdutoConstituidoIngrediente(newProduto);
        prodConstIngredRepository.save(produtoData);
        return;
    }
}
