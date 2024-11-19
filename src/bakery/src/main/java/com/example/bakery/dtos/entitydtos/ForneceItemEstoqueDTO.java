package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.ForneceItemEstoque;

import java.math.BigDecimal;

public record ForneceItemEstoqueDTO(String fornecedor_cnpj, Long id_ingrediente, Long quantidade, BigDecimal preco) {

    public ForneceItemEstoqueDTO(ForneceItemEstoque forneceItemEstoque){
        this(forneceItemEstoque.getFornecedor_cnpj(), forneceItemEstoque.getId_ingrediente(), forneceItemEstoque.getQuantidade(), forneceItemEstoque.getPreco());
    }
}
