package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.Produto;

import java.math.BigDecimal;

public record ProdutoDTO(Long id_produto,
        String nome, BigDecimal valor,
        Long quantidade, Long estoque_id_item) {

    public ProdutoDTO(Produto produto){
        this(produto.getId_produto(), produto.getNome(), produto.getValor(),
                produto.getQuantidade(), produto.getEstoque_id_item());
    }
}
