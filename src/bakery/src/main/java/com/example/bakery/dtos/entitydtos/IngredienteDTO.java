package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.Ingrediente;

public record IngredienteDTO(Long id_ingrediente, String nome,Long estoque_id_item) {

    public IngredienteDTO(Ingrediente ingrediente){
        this(ingrediente.getId_ingrediente(), ingrediente.getNome(),ingrediente.getEstoque_id_item());
    }
}
