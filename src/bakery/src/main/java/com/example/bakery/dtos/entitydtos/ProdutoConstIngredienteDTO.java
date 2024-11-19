package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.ProdutoConstituidoIngrediente;

public record ProdutoConstIngredienteDTO(Long id_produto, Long id_ingrediente, Long quantidade) {

    public ProdutoConstIngredienteDTO(ProdutoConstituidoIngrediente produtoConstIngred){
        this(produtoConstIngred.getId_produto(), produtoConstIngred.getId_ingrediente(), produtoConstIngred.getQuantidade());
    }
}
