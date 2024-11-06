package com.example.bakery.dtos.entitydtos.fornecedor;

import com.example.bakery.entities.Fornecedor;

public record FornecedorResponseDTO(String nome,
                                    String telefone, String email, String logradouro,
                                    String numero, String cep, String cidade, String uf) {

    public FornecedorResponseDTO(Fornecedor cliente) {
        this(cliente.getNome(),
                cliente.getTelefone(), cliente.getEmail(), cliente.getLogradouro(),
                cliente.getNumero(), cliente.getCep(), cliente.getCidade(), cliente.getUf());
    }
}
