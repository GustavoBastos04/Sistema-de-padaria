package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.ProdutosRestantesDTO;
import com.example.bakery.repositories.entities.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class ProdutosRestantesController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("produtos-restantes")
    public List<ProdutosRestantesDTO> getProdutosRestantes(){
    return produtoRepository.getProdutosRestantes();
    }
}
