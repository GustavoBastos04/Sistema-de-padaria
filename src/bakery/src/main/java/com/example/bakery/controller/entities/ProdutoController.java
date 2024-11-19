package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.*;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class ProdutoController {
    // PRODUTO
    @Autowired
    ProdutoRepository produtoRepository;
    @GetMapping("produto")
    public List<ProdutoDTO> getProdutos(){
        List<ProdutoDTO> produtosList = produtoRepository.getProdutos().stream().map(ProdutoDTO::new).toList();
        return produtosList;
    }
    @PostMapping("produto")
    public void saveProduto(@RequestBody ProdutoDTO newProduto){
        Produto produtoData = new Produto(newProduto);
        produtoRepository.save(produtoData);
        return;
    }

}
