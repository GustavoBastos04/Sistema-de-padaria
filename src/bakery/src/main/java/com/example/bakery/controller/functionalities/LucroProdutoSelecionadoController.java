package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.LucroProdutoDTO;
import com.example.bakery.repositories.entities.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("padaria")
public class LucroProdutoSelecionadoController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("lucro-produto-selecionado")
    public List<LucroProdutoDTO> getLucroProdutoSelecionado(@RequestParam Long id_produto){
        return vendaRepository.getLucroSelecionadoDTO(id_produto);
    }
}
