package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.ItemEstoque;

public record ItemEstoqueDTO(Long id_item) {
    public ItemEstoqueDTO(ItemEstoque itemEstoque){
        this(itemEstoque.getId_item());
    }
}
