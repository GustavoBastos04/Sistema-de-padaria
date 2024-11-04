package com.example.bakery.dtos;

import com.example.bakery.entities.Ingrediente;

public record IngredienteDTO(Long id_ingrediente, Long estoque_id_item) {

    public IngredienteDTO(Ingrediente ingrediente){
        this(ingrediente.getId_ingrediente(), ingrediente.getEstoque_id_item());
    }
}
