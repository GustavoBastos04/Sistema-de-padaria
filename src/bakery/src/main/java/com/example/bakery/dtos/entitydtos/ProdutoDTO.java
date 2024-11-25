package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.Produto;

import java.math.BigDecimal;

public record ProdutoDTO(Long id_produto,
        String nome, BigDecimal valor) {

    public ProdutoDTO(Produto produto){
        this(produto.getId_produto(), produto.getNome(), produto.getValor());
    }
}
