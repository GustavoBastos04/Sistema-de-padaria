package com.example.bakery.controller.functionalities;

import com.example.bakery.repositories.entities.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("padaria")
public class LucroProdutoController {

    @Autowired
    VendaRepository vendaRepository;


    @GetMapping("lucro-por-produto")
    public List<LucroProdutoDTO> getLucroProduto(){
        return vendaRepository.getLucroPorProduto();
    }
}
