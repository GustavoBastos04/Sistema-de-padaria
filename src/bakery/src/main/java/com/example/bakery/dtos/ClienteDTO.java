package com.example.bakery.dtos;

import com.example.bakery.entities.Cliente;

// DTO = Data Transfer Object
public record ClienteDTO(String cpf, String nome, String tipo_de_assinatura,
                         String telefone, String email, String logradouro,
                         String numero, String cep, String cidade, String uf) {

    public ClienteDTO(Cliente cliente) {
        this(cliente.getCpf(), cliente.getNome(), cliente.getTipo_de_assinatura(),
                cliente.getTelefone(), cliente.getEmail(), cliente.getLogradouro(),
                cliente.getNumero(), cliente.getCep(), cliente.getCidade(), cliente.getUf());
    }


}
